package com.daliciojunior.javatdd.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RecordTest {

    private Record record;

    @BeforeEach
    public void setup() {
        record = new Record();
    }

    @AfterEach
    public void teardown() {
        record = null;
    }

    @Test
    @DisplayName("""
            GIVEN: Integer id = 1;
            WHEN: calling getId();
            THEN: return 1;
            """)
    public void testRecordGetId() {
        // Arrange
        record.setId(1);
        Integer expected = 1;
        // Act
        Integer actual = record.getId();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("""
            GIVEN: String author = "Foo";
            WHEN: calling getAuthor();
            THEN: return "Foo";
            """)
    public void testRecordGetAuthor() {
        // Arrange
        record.setAuthor("Foo");
        String expected = "Foo";
        // Act
        String actual = record.getAuthor();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("""
            GIVEN: String message = "Foo Bar";
            WHEN: calling getMessage();
            THEN: return "Foo Bar";
            """)
    public void testRecordGetMessage() {
        // Arrange
        record.setMessage("Foo Bar");
        String expected = "Foo Bar";
        // Act
        String actual = record.getMessage();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("""
            GIVEN: Integer id = 1, String author = "Foo", String message = "Foo Bar";
            WHEN: calling getRecord();
            THEN: return Record({id = 1, author = "Foo", message = "Foo Bar"});
            """)
    public void testRecordGetRecord() {
        // Arrange
        record.setId(1);
        record.setAuthor("Foo");
        record.setMessage("Foo Bar");
        Record expected = new Record(1, "Foo", "Foo Bar");
        // Act
        String actual = record.toString();
        // Assert
        assertEquals(expected.toString(), actual);
    }

}