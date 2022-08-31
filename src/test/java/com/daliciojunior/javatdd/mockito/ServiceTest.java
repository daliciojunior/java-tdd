package com.daliciojunior.javatdd.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    private JSONObject json;
    private JSONArray array;

    @Mock
    private Repository repository;

    @InjectMocks
    private Service service;

    @BeforeEach
    public void setup() {
        json = new JSONObject();
        array = new JSONArray();
    }

    @AfterEach
    public void teardown() {
        json = null;
        array = null;
    }

    @Test
    public void testServiceCreate() throws JSONException {
        // Arrange
        when(repository.save(anyString(), anyString())).thenReturn(true);
        String expected = json.put("status", "success").toString();
        // Act
        JSONObject actual = service.create("Foo", "Hello, world!");
        // Assert
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testServiceCreateFailure() throws JSONException {
        // Arrange
        when(repository.save(anyString(), anyString())).thenReturn(false);
        String expected = json.put("status", "failure").toString();
        // Act
        JSONObject actual = service.create("Foo", "Goodbye, world...");
        // Assert
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testServiceFindOne() throws JSONException {
        // Arrange
        when(repository.findById(anyInt())).thenReturn(new Record(1, "Foo", "Bar"));
        String expected = json.put("data", new Record(1, "Foo", "Bar")).toString();
        // Act
        JSONObject actual = service.findOne(1);
        // Assert
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testServiceFindMany() throws JSONException {
        // Arrange 
        ArrayList<Record> queryResult = new ArrayList<>();
        queryResult.add(new Record(1, "Foo", "Hello, world!"));
        queryResult.add(new Record(2, "Foo", "Goodbye, world..."));
        when(repository.findByAuthor(anyString())).thenReturn(queryResult);
        array.put(queryResult.get(0));
        array.put(queryResult.get(1));
        String expected = array.toString();
        // Act
        JSONArray actual = service.findMany("Foo");
        // Assert
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testServiceRemoveOne() throws JSONException {
        // Arrange
        when(repository.removeById(anyInt())).thenReturn(new Record(1, "Foo", "Bar"));
        String expected = json.put("removed", new Record(1, "Foo", "Bar")).toString();
        // Act 
        JSONObject actual = service.removeOne(1);
        // Assert
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testServiceRemoveMany() throws JSONException {
        // Arrange
        ArrayList<Record> queryResult = new ArrayList<>();
        queryResult.add(new Record(1, "Foo", "Foo Bar"));
        queryResult.add(new Record(2, "Foo", "Bar Foo"));
        when(repository.removeByAuthor(anyString())).thenReturn(queryResult);
        array.put(queryResult.get(0));
        array.put(queryResult.get(1));
        String expected = array.toString();
        // Act
        JSONArray actual = service.removeMany("Foo");
        // Assert
        assertEquals(expected, actual.toString());
    }
    
}