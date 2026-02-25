package com.tss.MovieManagement.exceptions;

public class CapacityFullException extends Exception {

    private final int max_size;

    public CapacityFullException(int max_size){
        this.max_size=max_size;
    }
    @Override
    public String getMessage() {
        return "List is full You can't enter more than "+max_size;
    }
}
