package com.daliciojunior.javatdd.mockito;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Service {

    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public JSONObject create(String author, String message) {
        JSONObject json = new JSONObject();
        Boolean result = repository.save(author, message);
        if (result) {
            return json.put("status", "success");
        } else {
            return json.put("status", "failure");
        }
    }

    public JSONObject findOne(Integer id) {
        JSONObject json = new JSONObject();
        Record record = repository.findById(id);
        return json.put("data", record);
    }

    public JSONArray findMany(String author) {
        ArrayList<Record> queryResult = repository.findByAuthor(author);
        JSONArray array = new JSONArray();
        for (Record record : queryResult) {
            array.put(record);
        }
        return array;
    }

    public JSONObject removeOne(Integer id) {
        JSONObject json = new JSONObject();
        Record record = repository.removeById(id);
        return json.put("removed", record);
    }

    public JSONArray removeMany(String author) {
        ArrayList<Record> queryResult = repository.removeByAuthor(author);
        JSONArray array = new JSONArray();
        for (Record record : queryResult) {
            array.put(record);
        }
        return array;
    }
    
}