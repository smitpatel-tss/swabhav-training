package com.tss.LibraryManagement.service;

import com.tss.LibraryManagement.model.Member;
import com.tss.LibraryManagement.customExceptions.BookNotAvailableException;
import com.tss.LibraryManagement.customExceptions.BookNotFoundException;
import com.tss.LibraryManagement.customExceptions.MemberNotFoundException;
import com.tss.LibraryManagement.database.LibraryDatabase;
import com.tss.LibraryManagement.model.Book;
import com.tss.LibraryManagement.model.Categories;

import java.util.*;

import static com.tss.utils.GlobalConstants.scanner;
import static com.tss.utils.Validate.*;

public class LibraryService {
    private LibraryDatabase myLibraryDatabase;

    public LibraryService(){
        this.myLibraryDatabase =new LibraryDatabase();
    }

    public List<Book> getAllBooks(){
        return myLibraryDatabase.getBooks();
    }

    public void addBook() {
        System.out.print("Enter Title: ");
        String title = validateCharOnlyString();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        Categories category = getCategory();

        myLibraryDatabase.getBooks().add(new Book(title, author, category));
    }

    public Categories getCategory() {
        System.out.println("CATEGORIES:");
        Categories[] categories = Categories.values();

        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }
        System.out.print("Choose From Above: ");
        int choice = validatePositiveInt();

        while (choice > categories.length) {
            System.out.print("Choose Valid Option: ");
            choice = validatePositiveInt();
        }

        return categories[choice - 1];
    }


    public void addMember() {
        System.out.print("Enter Name: ");
        String name = validateCharOnlyString();

        while (true) {
            try {
                System.out.print("Enter Email: ");
                String email = validateEmail();

                if (myLibraryDatabase.getEmails().contains(email)) {
                    throw new RuntimeException("Email Already Exists!");
                }
                System.out.println("Member Added Successfully");
                myLibraryDatabase.getMembers().add(new Member(name, email));
                myLibraryDatabase.getEmails().add(email);
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void displayMembers() {
        if (myLibraryDatabase.getMembers().isEmpty()) {
            System.out.println("No Members are entered yet!");
            return;
        }
        System.out.println("Members:");
        for (Member member : myLibraryDatabase.getMembers()) {
            System.out.println(member);
        }
    }

    public void displayBooks(List<Book> bookList) {
        if (bookList.isEmpty()) {
            System.out.println("No Books Are there!");
            return;
        }
        System.out.printf("\n%-5s %-25s %-20s %-15s%n", "Id", "Title", "Author", "Category");
        System.out.println("----------------------------------------------------------------------");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void searchBorrower() {
        if (myLibraryDatabase.getBorrowedBooks().isEmpty()) {
            System.out.println("No books are Borrowed yet!");
            return;
        }
        Book book = getBookFromId();
        if (!myLibraryDatabase.getBorrowedBooks().containsKey(book)) {
            System.out.println("Book is Not Borrowed Yet!");
            return;
        }
        System.out.println(myLibraryDatabase.getBorrowedBooks().get(book));
    }

    public void borrowBook() {
        if (myLibraryDatabase.getBooks().isEmpty()) {
            System.out.println("Enter Books First!");
            return;
        }
        if (myLibraryDatabase.getMembers().isEmpty()) {
            System.out.println("Enter Members First!");
            return;
        }
        displayBooks(myLibraryDatabase.getBooks());
        System.out.println("\n-------Choose a Book From Above");
        Book myBook = getBookFromId();
        try {
            if (myLibraryDatabase.getBorrowedBooks().containsKey(myBook)) {
                throw new BookNotAvailableException("Book is Currently Unavailable!");
            }

            Member member = getMemberFromId();
            List<Book> takenBooks = myLibraryDatabase.getBooksBorrowedByMember().getOrDefault(member, new ArrayList<>());
            takenBooks.add(myBook);
            myLibraryDatabase.getBooksBorrowedByMember().put(member, takenBooks);
            myLibraryDatabase.getBorrowedBooks().put(myBook, member);
            System.out.println(myBook.getTitle() + " is Borrowed by " + member.getName() + " Successfully...");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayBooksBorrowedByMember() {
        if (myLibraryDatabase.getMembers().isEmpty()) {
            System.out.println("Enter Member First!");
            return;
        }
        displayMembers();
        System.out.println("\n-------Choose a Member From Above");
        Member member = getMemberFromId();
        if (!myLibraryDatabase.getBooksBorrowedByMember().containsKey(member)) {
            System.out.println(member.getName() + " Not Borrowed Any Book.");
            return;
        }
        displayBooks(myLibraryDatabase.getBooksBorrowedByMember().get(member));
    }

    public Member getMemberFromId() {

        while (true) {
            try {
                System.out.print("\nEnter Member Id: ");
                int id = validatePositiveInt();
                for (Member member : myLibraryDatabase.getMembers()) {
                    if (member.getId() == id) {
                        return member;
                    }
                }
                throw new MemberNotFoundException("Member Not Found!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public Book getBookFromId() {
        while (true) {
            try {
                System.out.print("\nEnter Book Id: ");
                int id = validatePositiveInt();

                for (Book book : myLibraryDatabase.getBooks()) {
                    if (book.getId() == id) {
                        return book;
                    }
                }
                throw new BookNotFoundException("Book Not Found!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
