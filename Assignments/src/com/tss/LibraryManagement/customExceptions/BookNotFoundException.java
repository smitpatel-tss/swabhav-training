package com.tss.LibraryManagement.customExceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
    public String getMessage(){
        return "Book Not Found!";
    }
}
