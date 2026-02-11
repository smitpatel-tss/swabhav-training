package com.tss.MovieManagement;

import java.util.Scanner;


public class MovieController {
    MovieManager manager;
    static Scanner scanner=new Scanner(System.in);

    public MovieController(){
        manager=new MovieManager();
    }

    public void start(){
        displayMenu();
    }
    public void displayMenu(){
        System.out.println("\nMAIN MENU: ");
        System.out.println("1. Display Movies");
        System.out.println("2. Add Movie");
        System.out.println("3. Save Current Movies to Database");
        System.out.println("4. Clear Current Movies");
        System.out.println("5. Clear Whole Database");
        System.out.println("6. Change Movie Details");
        System.out.println("7. Exit");
    }

    public Movie getMovieById(int id){
        for(Movie movie: manager.movies){
            if(movie.getId()==id){
                return movie;
            }
        }
        return null;
    }

    public void setMovieDetails() throws NoSuchMovieFoundException {
        System.out.print("Enter Id: ");
        int id=scanner.nextInt();
        scanner.nextLine();

        Movie movie=getMovieById(id);
        if(movie==null){
            throw new NoSuchMovieFoundException();
        }
        System.out.print("Enter Name: ");
        String name=scanner.nextLine();

        System.out.print("Enter Year: ");
        int year=scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Genre: ");
        String genre=scanner.nextLine();

        movie.setName(name);
        movie.setYear(year);
        movie.setGenre(genre);
    }
}
