package com.tss.MovieManagement;

public class NoSuchMovieFoundException extends Exception{
    @Override
    public String getMessage() {
        return "No Such Movie Available in Database!";
    }
}
