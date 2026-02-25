package com.tss.MovieManagement.service;

import com.tss.MovieManagement.exceptions.CapacityFullException;
import com.tss.MovieManagement.model.Movie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private List<Movie> movies;
    private static final String filePath="moviesList.ser";
    private static final int CAPACITY=50;

    public MovieService(){
        movies=new ArrayList<>();
        loadMovies();
    }

    public void loadMovies(){

        File file=new File(filePath);

        if(!file.exists() || file.length()==0){
            return;
        }
        try{
            FileInputStream fileIn=new FileInputStream(filePath);
            ObjectInputStream objIn=new ObjectInputStream(fileIn);

            movies=(List<Movie>) objIn.readObject();

            fileIn.close();
            objIn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addMovie(String name,int year, String genre) throws CapacityFullException {
        if(movies.size()==50){
            throw new CapacityFullException(CAPACITY);
        }
        Movie movie=new Movie(movies.size(),name,year,genre);
        movies.add(movie);
    }
    public void clearMovies(){
        movies.clear();
    }
    public void saveMovies(){
        try{
            FileOutputStream fileOut=new FileOutputStream(filePath);
            ObjectOutputStream objOut=new ObjectOutputStream(fileOut);

            objOut.writeObject(movies);

            fileOut.close();
            objOut.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAllMovies(){

        movies.clear();
        saveMovies();
    }

    public void displayAll(){
        for(Movie movie:movies){
            System.out.println("------------------------------------------------------");
            System.out.println("Id: "+movie.getId());
            System.out.println("Name: "+movie.getName());
            System.out.println("Year: "+movie.getYear());
            System.out.println("Genre: "+movie.getGenre());
        }
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
