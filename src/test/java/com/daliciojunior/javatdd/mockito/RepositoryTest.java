package com.daliciojunior.javatdd.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
    public void testRepositorySave() {
        // Arrange
        Boolean expected = true;
        // Act
        Boolean actual = repository.save("Foo", "Hello, world!");
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testRepositoryFindById() {
        // Arrange
        Record expected = new Record(1, "Bar", "Goodbye, world...");
        repository.save("Bar", "Goodbye, world...");
        // Act
        Record actual = repository.findById(1);
        // Assert
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testRepositoryFindByAuthor() {
        // Arrange
        ArrayList<Record> expected = new ArrayList<>();
        expected.add(new Record(1, "Foo", "Hello, world!"));
        expected.add(new Record(3, "Foo", "I love TDD!"));
        repository.save("Foo", "Hello, world!");
        repository.save("Bar", "Goodbye, world...");
        repository.save("Foo", "I love TDD!");
        // Act
        ArrayList<Record> actual = repository.findByAuthor("Foo");
        // Assert
        assertEquals(expected.get(0).toString(), actual.get(0).toString());
        assertEquals(expected.get(1).toString(), actual.get(1).toString());
    }

    @Test
    public void testRepositoryRemoveById() {
        // Arrange
        Record expected = new Record(1, "Foo", "Hello, world!");
        repository.save("Foo", "Hello, world!");
        // Act
        Record actual = repository.removeById(1);
        // Assert
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testRepositoryRemoveByAuthor() {
        // Arrange
        ArrayList<Record> expected = new ArrayList<>();
        expected.add(new Record(1, "Foo", "Hello, world!"));
        expected.add(new Record(2, "Foo", "I love TDD!"));
        repository.save("Foo", "Hello, world!");
        repository.save("Foo", "I love TDD!");
        // Act
        ArrayList<Record> actual = repository.removeByAuthor("Foo");
        // Assert
        assertEquals(expected.get(0).toString(), actual.get(0).toString());
        assertEquals(expected.get(1).toString(), actual.get(1).toString());
    }
}