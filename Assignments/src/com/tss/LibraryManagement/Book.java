package com.tss.LibraryManagement;

public class Book {
    private final int id;
    private static int temp = 1;
    private String title;
    private String author;
    private final Categories category;

    public Book(String title, String author, Categories category) {
        this.id = temp++;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format(
                "%-5d %-25s %-20s %-15s",
                id, title, author, category
        );
    }

}
