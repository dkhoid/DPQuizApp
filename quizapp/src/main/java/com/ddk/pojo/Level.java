package com.ddk.pojo;

public class Level {
    private int id;
    private String name;
    private String note;

    public Level(int id, String name, String note) {
        this.id = id;
        this.name = name;
        this.note = note;
    }
    
    public Level(String name, String note) {
        this.name = name;
        this.note = note;
    }

    @Override
    public String toString() { return this.name; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}