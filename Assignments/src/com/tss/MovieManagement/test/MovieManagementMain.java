package com.tss.MovieManagement.test;

import com.tss.MovieManagement.exceptions.CapacityFullException;
import com.tss.MovieManagement.exceptions.NoSuchMovieFoundException;
import com.tss.MovieManagement.model.MovieController;

import java.util.Scanner;

public class MovieManagementMain {
    static MovieController controller=new MovieController();
    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            controller.start();
            System.out.print("Enter Your Choice: ");
            int choice=scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    controller.getManager().displayAll();
                    break;
                case 2:
                    createNewMovie();
                    break;
                case 3:
                    controller.getManager().saveMovies();
                    break;
                case 4:
                    controller.getManager().clearMovies();
                    break;
                case 5:
                    controller.getManager().deleteAllMovies();
                    break;
                case 6:
                    try {
                        controller.setMovieDetails();
                    }catch (NoSuchMovieFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("EXITING...");
                    return;
            }
        }
    }

    public static void createNewMovie(){
        System.out.print("Enter Name: ");
        String name =scanner.nextLine();

        System.out.print("Enter Year: ");
        int year=scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Genre: ");
        String genre=scanner.nextLine();

        try {
            controller.getManager().addMovie(name,year,genre);
        }catch (CapacityFullException e){
            System.out.println(e.getMessage());
        }
    }
}
