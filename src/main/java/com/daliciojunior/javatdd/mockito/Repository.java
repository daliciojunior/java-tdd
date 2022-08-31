package com.daliciojunior.javatdd.mockito;

import java.util.ArrayList;
import java.util.HashMap;

public class Repository {

    private Integer id;

    private HashMap<Integer, Record> records;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer idGenerator() {
        Integer aux = getId();
        setId(aux + 1);
        return aux;
    }

    public Repository() {
        id = 1;
        records = new HashMap<>();
    }

    public Boolean save(String author, String message) {
        records.put(getId(), new Record(getId(), author, message));
        idGenerator();
        return true;
    }

    public Record findById(Integer id) {
        return records.get(id);
    }

    public ArrayList<Record> findByAuthor(String author) {
        ArrayList<Record> queryResult = new ArrayList<>();
        for (Record record : records.values()) {
            if (record.getAuthor() == author) {
                queryResult.add(record);
            }
        }
        return queryResult;
    }

    public Record removeById(Integer id) {
        if (records.containsKey(id)) {
            return records.remove(id);
        } else {
            return null;
        }
    }

    public ArrayList<Record> removeByAuthor(String author) {
        ArrayList<Record> queryResult = new ArrayList<>();
        for (Record record : records.values()) {
            if (record.getAuthor() == author) {
                queryResult.add(record);
            }
        }
        for (Record record : queryResult) {
            records.remove(record.getId());
        }
        return queryResult;
    }

}