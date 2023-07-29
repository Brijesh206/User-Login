package com.userlogin.model;

public class Operation {
    private String name;
    private String work;

    public Operation() {
    }

    public Operation(String name, String work) {
        this.name = name;
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
