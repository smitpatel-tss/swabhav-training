package com.tss.utils;

import static com.tss.utils.GlobalConstants.scanner;

public class Validate {

    public static boolean validateBoolean() {
        boolean temp;
        while (true) {
            if (scanner.hasNextBoolean()) {
                temp = scanner.nextBoolean();
                return temp;
            }
            System.out.print("Enter valid value:");
            scanner.next();
        }
    }

    public static int validatePositiveInt() {
        while (true) {
            if (scanner.hasNextInt()) {
                int temp = scanner.nextInt();
                if (temp >= 0) {
                    return temp;
                }
                System.out.print("Enter Positive Number: ");
            } else {
                System.out.print("Enter valid number: ");
                scanner.next();
            }
        }
    }

    public static double validatePositiveDouble() {
        while (true) {
            if (scanner.hasNextDouble()) {
                double temp = scanner.nextDouble();
                if (temp >= 0) {
                    return temp;
                }
                System.out.print("Enter positive number: ");
            } else {
                System.out.print("Enter valid number: ");
                scanner.next();
            }
        }
    }

    public static long validatePositiveLong() {
        while (true) {
            if (scanner.hasNextLong()) {
                long temp = scanner.nextLong();
                if (temp >= 0) {
                    return temp;
                }
                System.out.print("Enter Positive Number: ");
            } else {
                System.out.print("Enter valid number: ");
                scanner.next();
            }
        }
    }

    public static String validateCharOnlyString() {
        while (true) {
            String temp = scanner.nextLine();
            if (temp.matches("[a-zA-Z ]+")) {
                return temp;
            }
            System.out.print("Enter Characters Only: ");
        }
    }

    public static String validateCharAndNumberOnlyString() {
        while (true) {
            String temp = scanner.nextLine();
            if (temp.matches("[0-9a-zA-Z ]+")) {
                return temp;
            }
            System.out.print("Enter Characters Only: ");
        }
    }

    public static String validateEmail() {
        while (true) {
            String email = scanner.nextLine().trim();

            if (email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                return email;
            }

            System.out.print("Invalid email. Enter again: ");
        }
    }

}