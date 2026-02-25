package com.tss.LibraryManagement.database;

import com.tss.LibraryManagement.model.Member;
import com.tss.LibraryManagement.model.Book;
import com.tss.LibraryManagement.model.Library;

import java.util.*;

public class LibraryDatabase {

    private Set<String> emails;
    private List<Member> members;
    private List<Book> books;
    private HashMap<Book, Member> borrowedBooks;
    private HashMap<Member, List<Book>> booksBorrowedByMember;

    public LibraryDatabase(){
        this.emails = new HashSet<>();
        this.members = new ArrayList<>();
        this.books = new Library().getBooks();
        this.borrowedBooks = new HashMap<>();
        this.booksBorrowedByMember = new HashMap<>();
    }

    public Set<String> getEmails() {
        return emails;
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Book> getBooks() {
        return books;
    }

    public HashMap<Book, Member> getBorrowedBooks() {
        return borrowedBooks;
    }

    public HashMap<Member, List<Book>> getBooksBorrowedByMember() {
        return booksBorrowedByMember;
    }
}
