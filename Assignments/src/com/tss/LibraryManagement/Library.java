package com.tss.LibraryManagement;

import com.tss.LibraryManagement.customExceptions.BookNotAvailableException;
import com.tss.LibraryManagement.customExceptions.BookNotFoundException;
import com.tss.LibraryManagement.customExceptions.MemberNotFoundException;

import java.util.*;

import static com.tss.utils.GlobalConstants.scanner;
import static com.tss.utils.Validate.*;

public class Library {
    public Set<String> emails = new HashSet<>();
    public List<Member> members = new ArrayList<>();
    public List<Book> books = new ArrayList<>();
    public HashMap<Book, Member> borrowedBooks = new HashMap<>();
    public HashMap<Member, List<Book>> booksBorrowedByMember = new HashMap<>();


    public void addBook() {
        System.out.print("Enter Title: ");
        String title = validateCharOnlyString();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        Categories category = getCategory();

        books.add(new Book(title, author, category));
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

                if (emails.contains(email)) {
                    throw new RuntimeException("Email Already Exists!");
                }
                System.out.println("Member Added Successfully");
                members.add(new Member(name, email));
                emails.add(email);
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No Members are entered yet!");
            return;
        }
        System.out.println("Members:");
        for (Member member : members) {
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
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books are Borrowed yet!");
            return;
        }
        Book book = getBookFromId();
        if (!borrowedBooks.containsKey(book)) {
            System.out.println("Book is Not Borrowed Yet!");
            return;
        }
        System.out.println(borrowedBooks.get(book));
    }

    public void borrowBook() {
        if (books.isEmpty()) {
            System.out.println("Enter Books First!");
            return;
        }
        if (members.isEmpty()) {
            System.out.println("Enter Members First!");
            return;
        }
        displayBooks(books);
        System.out.println("\n-------Choose a Book From Above");
        Book myBook = getBookFromId();
        try {
            if (borrowedBooks.containsKey(myBook)) {
                throw new BookNotAvailableException("Book is Currently Unavailable!");
            }

            Member member = getMemberFromId();
            List<Book> takenBooks = booksBorrowedByMember.getOrDefault(member, new ArrayList<>());
            takenBooks.add(myBook);
            booksBorrowedByMember.put(member, takenBooks);
            borrowedBooks.put(myBook, member);
            System.out.println(myBook.getTitle() + " is Borrowed by " + member.getName() + " Successfully...");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayBooksBorrowedByMember() {
        if (members.isEmpty()) {
            System.out.println("Enter Member First!");
            return;
        }
        displayMembers();
        System.out.println("\n-------Choose a Member From Above");
        Member member = getMemberFromId();
        if (!booksBorrowedByMember.containsKey(member)) {
            System.out.println(member.getName() + " Not Borrowed Any Book.");
            return;
        }
        displayBooks(booksBorrowedByMember.get(member));
    }

    public Member getMemberFromId() {

        while (true) {
            try {
                System.out.print("\nEnter Member Id: ");
                int id = validatePositiveInt();
                for (Member member : members) {
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

                for (Book book : books) {
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
