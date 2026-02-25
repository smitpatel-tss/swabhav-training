package com.tss.LibraryManagement.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    public Library(){
        books=new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }
}
