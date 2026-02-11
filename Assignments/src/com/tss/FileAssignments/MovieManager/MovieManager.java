package com.tss.FileAssignments.MovieManager;

import java.io.*;
import java.util.List;

public class MovieManager implements Serializable {
    List<Movie> movies;

    public MovieManager(List<Movie> movies) {
//        this.movies = movies;
        loadMovies();
    }

    public void loadMovies(){
        try{
            File file = new File("moviesList.ser");
            if(!file.exists()){
                return;
            }
            FileInputStream fileIn=new FileInputStream(file);
            ObjectInputStream objIn=new ObjectInputStream(fileIn);
            MovieManager listOfMovies=(MovieManager) objIn.readObject();

            this.movies.addAll(listOfMovies.movies);

            fileIn.close();
            objIn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public void clearMovies(){
        this.movies.clear();
    }

    public void saveMovies(){
        try{
            ObjectOutputStream objIn=new ObjectOutputStream(new FileOutputStream("moviesList.ser"));
            objIn.writeObject(this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteAllMovies(){
        movies.clear();
        saveMovies();
    }
}
