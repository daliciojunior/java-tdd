package com.daliciojunior.javatdd.mockito;

public class Record {

    private Integer id;
    private String author;
    private String message;

    public Record(Integer id, String author, String message) {
        this.id = id;
        this.author = author;
        this.message = message;
    }

    public Record() {}
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "{id=" + getId() + ", author=" + getAuthor() + ", message=" + getMessage() + "}";
    }
    
}