package com.tss.MovieManagement;

import java.util.Scanner;

public class MovieManagerApp {
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
                    controller.manager.displayAll();
                    break;
                case 2:
                    createNewMovie();
                    break;
                case 3:
                    controller.manager.saveMovies();
                    break;
                case 4:
                    controller.manager.clearMovies();
                    break;
                case 5:
                    controller.manager.deleteAllMovies();
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
            controller.manager.addMovie(name,year,genre);
        }catch (CapacityFullException e){
            System.out.println(e.getMessage());
        }
    }
}
