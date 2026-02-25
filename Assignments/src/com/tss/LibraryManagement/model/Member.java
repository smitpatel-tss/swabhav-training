package com.tss.LibraryManagement.model;

public class Member {
    private final int id;
    private static int temp = 1;
    private String name;
    private String email;

    public Member(String name, String email) {
        this.id = temp++;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "\nId: " + id + "\nName: " + name + "\nEmail: " + email;
    }
}
