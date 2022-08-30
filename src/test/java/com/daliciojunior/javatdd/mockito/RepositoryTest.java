package com.daliciojunior.javatdd.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    private Repository repository;

    @BeforeEach
    public void setup() {
        repository = new Repository();
    }

    @AfterEach
    public void teardown() {
        repository = null;
    }

    @Test
    @DisplayName("""
            GIVEN: String author = "Foo", message = "Hello, world!";
            WHEN: calling repository.save("Foo", "Hello, world!");
            THEN: return true;
            """)
    public void testRepositorySaveRecord() {
        // Arrange
        boolean expected = true;
        // Act
        boolean actual = repository.save("Foo", "Hello, world!");
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("""
            GIVEN: String author = "Bar", message = "Goodbye, world...";
            WHEN: calling repository.findById(1);
            THEN: return Record@{id=1, author="Bar", message="Goodbye, world..."};
            """)
    public void testRepositoryFindById() {
        // Arrange
        Record expected = new Record(1, "Bar", "Goodbye, world...");
        repository.save("Bar", "Goodbye, world...");
        // Act
        Record actual = repository.findById(1);
        // Assert
        // I'm not comparing equality but identity since they have different memory adressess
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    @DisplayName("""
            GIVEN: {
                String author = "Foo", message = "Hello, world!";
                String author = "Foo", message = "I love TDD!";
                String author = "Foo", message = "Goodbye, world...";
                String author = "Bar", mesage = "Spam Spam Spam";
            };
            WHEN: calling repository.findByAuthor("Foo");
            THEN: return {
                Record@{id=1, author="Foo", message="Hello, world!"},
                Record@{id=2, author="Foo", message="I love TDD!"},
                Record@{id=3, author="Foo", mesage="Goodbye, world..."}
            };
            """)
    public void testRepositoryFindByAuthor() {
        // Arrange
        repository.save("Foo", "Hello, world!");
        repository.save("Foo", "I love TDD!");
        repository.save("Foo", "Goodbye, world...");
        repository.save("Bar", "Spam Spam Spam");
        ArrayList<Record> expected = new ArrayList<>();
        expected.add(new Record(1, "Foo", "Hello, world!"));
        expected.add(new Record(2, "Foo", "I love TDD!"));
        expected.add(new Record(3, "Foo", "Goodbye, world..."));
        // Act
        ArrayList<Record> actual = repository.findByAuthor("Foo");
        // Assert
        // I'm not comparing equality but identity since they have different memory adressess
        assertEquals(expected.toArray()[0].toString(), actual.toArray()[0].toString());
        assertEquals(expected.toArray()[1].toString(), actual.toArray()[1].toString());
        assertEquals(expected.toArray()[2].toString(), actual.toArray()[2].toString());
    }

    @Test
    @DisplayName("""
            GIVEN: String author = "Foo", String message = "Foo Bar";
            WHEN: calling repository.removeById(1);
            THEN: return Record@{id=1, author="Foo", message="Foo Bar"};
            """)
    public void testRepositoryRemoveById() {
        // Arrange
        repository.save("Foo", "Foo Bar");
        Record expected = new Record(1, "Foo", "Foo Bar");
        // Act
        Record actual = repository.removeById(1);
        // Assert
        // I'm not comparing equality but identity since they have different memory adressess
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    @DisplayName("""
            GIVEN: {
                String author = "Foo", message = "Hello, world!";
                String author = "Foo", message = "Goodbye, world...";
            };
            WHEN: calling repository.removeByAuthor("Foo");
            THEN: return {
                Record@{id=1, author="Foo", message="Hello, world!"},
                Record@{id=2, author="Foo", message="Goodbye, wordl..."}
            };
            """)
    public void testRepositoryRemoveByAuthor() {
        // Arrange
        repository.save("Foo", "Hello, world!");
        repository.save("Foo", "Goodbye, world...");
        ArrayList<Record> expected = new ArrayList<>();
        expected.add(new Record(1, "Foo", "Hello, world!"));
        expected.add(new Record(2, "Foo", "Goodbye, world..."));
        // Act
        ArrayList<Record> actual = repository.removeByAuthor("Foo");
        // Assert
        // I'm not comparing equality but identity since they have different memory adressess
        assertEquals(expected.toArray()[0].toString(), actual.toArray()[0].toString());
        assertEquals(expected.toArray()[1].toString(), actual.toArray()[1].toString());
    }

}