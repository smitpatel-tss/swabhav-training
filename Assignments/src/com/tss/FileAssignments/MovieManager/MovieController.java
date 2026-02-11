package com.tss.FileAssignments.MovieManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.tss.utils.Validate.*;

public class MovieController {
    MovieManager manager;
    Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        MovieController controller=new MovieController();
        controller.manager=new MovieManager(new ArrayList<Movie>());

        while(true){
            start();
            System.out.print("\nEnter Your Choice: ");
            int choice= validatePositiveInt();

            while (!(choice>0 && choice<7)){
                System.out.print("Enter valid Choice: ");
                choice= validatePositiveInt();
            }

            switch (choice){
                case 1:
                    controller.displayMovies();
                    break;
                case 2:
                    controller.addMovie();
                    break;
                case 3:
                    controller.manager.clearMovies();
                    break;
                case 4:
                    controller.manager.deleteAllMovies();
                    break;
                case 5:
                    controller.manager.saveMovies();
                    break;
                case 6:
                    System.out.println("EXITING...");
                    return;
            }
        }
    }

    public void displayMovies(){
        for(Movie movie: manager.movies){
            System.out.println("-----------------------------------------------------------");
            System.out.println("ID: "+movie.getId());
            System.out.println("Name: "+movie.getName());
            System.out.println("Year: "+movie.getYear());
            System.out.println("Genre: "+movie.getGenre());
            System.out.println("-----------------------------------------------------------");

        }
    }

    public MovieController(MovieManager manager){
        this.manager=manager;
    }
    public MovieController(){
        this(null);
    }

    public static void start(){
        displayMenu();
    }

    public static void displayMenu(){
        System.out.println("\nMAIN MENU");
        System.out.println("1. Display Movies");
        System.out.println("2. Add Movie");
        System.out.println("3. Clear all current");
        System.out.println("4. Clear all From Database");
        System.out.println("5. Save the state");
        System.out.println("6. Exit");
    }

    public void setMovieDetails(){
        System.out.print("Enter Id: ");
        int id= validatePositiveInt();

        Movie selectedMovie=getMovieFromId(id);

        if(selectedMovie==null){
            System.out.println("Movie not Available!");
            return;
        }
        System.out.print("Enter Movie Name: ");
        String name= scanner.nextLine();

        System.out.print("Enter Year: ");
        int year= validatePositiveInt();

        System.out.print("Enter Genre: ");
        String genre=scanner.nextLine();

        selectedMovie.setName(name);
        selectedMovie.setYear(year);
        selectedMovie.setGenre(genre);

    }

    public Movie getMovieFromId(int id){
        List<Movie> allMovies=this.manager.movies;

        for(Movie movie:allMovies){
            if(movie.getId()==id){
                return movie;
            }
        }
        return null;
    }

    public void addMovie(){
        System.out.print("Enter Movie Name: ");
        String name= scanner.nextLine();

        System.out.print("Enter Year: ");
        int year= validatePositiveInt();

        System.out.print("Enter Genre: ");
        String genre=scanner.nextLine();

        Movie newMovie=new Movie(manager.movies.size()+1,name,year,genre);
        manager.addMovie(newMovie);

        System.out.println("NEW MOVIE ADDED SUCCESSFULLY!");
    }

}
