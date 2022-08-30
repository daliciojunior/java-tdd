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

    private Integer idGenerator() {
        Integer aux = getId();
        setId(getId() + 1);
        return aux;
    }

    public Repository() {
        id = 1;
        records = new HashMap<>();
    }

    public boolean save(String author, String message) {
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
        ArrayList<Record> recordsToRemove = new ArrayList<>();
        for (Record record : records.values()) {
            if (record.getAuthor() == author) {
                queryResult.add(record);
                recordsToRemove.add(record);
            }
        }
        for (Record record : recordsToRemove) {
            records.remove(record.getId());
        }
        return queryResult;
    }

}