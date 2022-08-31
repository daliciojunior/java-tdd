package com.daliciojunior.javatdd.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
    public void testRecordToString() {
        // Arrange
        record.setId(1);
        record.setAuthor("Foo");
        record.setMessage("Foo Bar");
        String expected = "{id=1, author=Foo, message=Foo Bar}";
        // Act
        String actual = record.toString();
        // Assert
        assertEquals(expected, actual);
    }

}