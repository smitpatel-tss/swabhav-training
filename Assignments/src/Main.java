import com.tss.oop.Course;
import com.tss.oop.Student;

import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter your string:");
        String str=scanner.next();
        scanner.nextLine();
        if(isPalindrom(str)){
            System.out.println("Yest it is palindrome");
        }else{
            System.out.println("No it is not a Palindrome!");
        }

    }
    public static boolean isPalindrom(String str) {

        StringBuilder strB = new StringBuilder(str);

        return str.equals(strB.reverse().toString());
    }

}

//-------

//package com.tss.oop;
//
//import java.util.Scanner;
//import java.util.Random;
//
//public class MainStudent {
//    static Scanner scanner = new Scanner(System.in);
//    static Random random = new Random();
//    static Course[] courseList = new Course[5];
//    static Student[] studentList = new Student[10];
//    static int totalStudents;
//
//    public static void main(String[] args) {
//
//        System.out.print("Enter the number of Courses you want to enter (max=5):");
//        int numOfCourses = scanner.nextInt();
//        scanner.nextLine();
//        while (true) {
//            if (numOfCourses <= 0 || numOfCourses > 5) {
//                System.out.print("Enter valid amount from 1 to 5:");
//                numOfCourses = scanner.nextInt();
//            } else {
//                break;
//            }
//        }
//        for (int i = 0; i < numOfCourses; i++) {
//            System.out.println("\nEnter details for course " + (i + 1));
//            courseList[i] = makeCourse();
//        }
//
//        System.out.print("\nEnter Number of Student You Want to enter(max 10):");
//        totalStudents = scanner.nextInt();
//        while (true) {
//            if (totalStudents <= 0 || totalStudents > 10) {
//                System.out.print("Enter valid amount from 1 to 10:");
//                totalStudents = scanner.nextInt();
//            } else {
//                break;
//            }
//        }
//        scanner.nextLine();
//        for (int i = 0; i < totalStudents; i++) {
//            System.out.println("\nFor Student " + (i + 1));
//            studentList[i] = createStudent();
//        }
//
//        while (true) {
//            System.out.println("\n=====MAIN MENU=====");
//            System.out.println("1. Add Student");
//            System.out.println("2. Add new Course");
//            System.out.println("3. Display Student Profile");
//            System.out.println("4. Display all Students");
//            System.out.println("5. Display all Courses");
//            System.out.println("6. Pay Fees");
//            System.out.println("7. View Pending Fees");
//            System.out.println("8. Update Course");
//            System.out.println("9. Exit");
//
//            System.out.print("Enter The Choice:");
//            int choice = scanner.nextInt();
//            while (true) {
//                if (choice <= 0 || choice > 9) {
//                    System.out.print("Enter Valid value:");
//                    choice = scanner.nextInt();
//                } else {
//                    break;
//                }
//            }
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1:
//                    if (com.tss.oop.MainStudent.totalStudents <=10) {
//                        studentList[com.tss.oop.MainStudent.totalStudents] = createStudent();
//                        com.tss.oop.MainStudent.totalStudents++;
//                    }
//                    break;
//
//                case 2:
//                    int count = 0;
//                    for (Course courses : courseList) {
//                        count++;
//                        if (courses == null) {
//                            courses = makeCourse();
//                            break;
//                        }
//                    }
//                    if (count == 5) {
//                        System.out.println("You can't enter more than 5 courses!");
//                    }
//                    break;
//
//                case 3:
//                    System.out.println("Enter student id :");
//                    int idToDisplay = scanner.nextInt();
//                    if (findStudentById(idToDisplay) == null) {
//                        System.out.println("There is no Student with such ID!");
//                    } else {
//                        findStudentById(idToDisplay).displayProfile();
//                    }
//                    break;
//
//                case 4:
//                    displayAllStudents();
//                    break;
//
//                case 5:
//                    displayAllCourses();
//                    break;
//
//                case 6:
//                    System.out.println("Enter student id :");
//                    int idToPayFees = scanner.nextInt();
//                    if (findStudentById(idToPayFees) == null) {
//                        System.out.println("There is no Student with such ID!");
//                    } else {
//                        Student studentTemp = findStudentById(idToPayFees);
//                        System.out.println("Remaining fees for " + studentTemp.getName() + " :" + (studentTemp.getTotalFees() - studentTemp.getFeesPaid()));
//                        System.out.print("Enter fees you want to pay:");
//                        double fees = scanner.nextDouble();
//                        while (true) {
//                            if (fees > (studentTemp.getTotalFees() - studentTemp.getFeesPaid())) {
//                                System.out.print("Enter remaining payable amount only:");
//                                fees = scanner.nextDouble();
//                            } else {
//                                break;
//                            }
//                        }
//                        studentTemp.setFeesPaid(studentTemp.getFeesPaid() + fees);
//                        if (studentTemp.getTotalFees() == studentTemp.getFeesPaid()) {
//                            System.out.println("ALL FEES COMPLETED!");
//                        }
//                    }
//                    break;
//                case 7:
//                    System.out.println("Enter student id :");
//                    int idForPendingFees = scanner.nextInt();
//                    if (findStudentById(idForPendingFees) == null) {
//                        System.out.println("There is no Student with such ID!");
//                    } else {
//                        Student tempFor6 = findStudentById(idForPendingFees);
//                        System.out.println("Pending fees for " + tempFor6.getName() + " :" + (tempFor6.getTotalFees() - tempFor6.getFeesPaid()));
//                    }
//                    break;
//
//                case 8:
//                    System.out.println("Enter student id :");
//                    int idForCourseUpdate = scanner.nextInt();
//                    if (findStudentById(idForCourseUpdate) == null) {
//                        System.out.println("There is no Student with such ID!");
//                    } else {
//                        Student tempFor7 = findStudentById(idForCourseUpdate);
//                        addNewSubject(tempFor7);
//                    }
//                    break;
//
//                case 9:
//                    System.out.println("Exiting...");
//                    return;
//
//                default:
//                    System.out.println("Enter valid value from 1-9");
//
//
//            }
//        }
//
//    }
//
//    private static Student findStudentById(int idToSearch) {
//        for (Student studentFromList : studentList) {
//            if (studentFromList == null) {
//                break;
//            }
//            if (studentFromList.getId() == idToSearch) {
//                return studentFromList;
//            }
//        }
//        return null;
//    }
//
//    private static void addNewSubject(Student student) {
//        for (Course courses : student.getCourse()) {
//            if (courses == null) {
//                displayAllCourses();
//                System.out.print("Enter the course you want to enter:");
//                int courseNum = scanner.nextInt();
//                courses = courseList[courseNum - 1];
//                student.setTotalFees(student.getTotalFees() + courses.getFees());
//                return;
//            }
//        }
//        System.out.println("3 slots for Course is full! You can't enter more!!!");
//    }
//
//    private static void displayAllStudents() {
//        System.out.printf("%-5s %-15s %-15s %12s %-15s%n", "Id", "Name", "Courses", "Fees Paid", "Total Fees");
//
//        for (int i = 0; i <= totalStudents; i++) {
//            if (studentList[i] == null) {
//                break;
//            }
//            System.out.printf("%-5d %-15s %-15s %12.2f %-15.2f%n", studentList[i].getId(), studentList[i].getName(), getNameOfCourses(studentList[i]), studentList[i].getFeesPaid(), studentList[i].getTotalFees());
//        }
//    }
//
//    private static String getNameOfCourses(Student student) {
//        String ans = "";
//        for (Course courses : student.getCourse()) {
//            if (courses == null) {
//                break;
//            }
//            ans += courses.getName() + " | ";
//        }
//        return ans;
//    }
//
//
//    private static void displayAllCourses() {
//        System.out.println("\nAll available courses:");
//        for (int i = 0; i < courseList.length; i++) {
//            if (courseList[i] == null) {
//                break;
//            }
//            System.out.println((i + 1) + "------");
//            courseList[i].displayCourse();
//        }
//    }
//
//    private static Course makeCourse() {
////        System.out.println("Enter Details about Course:");
//
//        System.out.print("\nEnter name of the Course:");
//        String name = scanner.nextLine();
//
//
//        System.out.print("Enter Duration of the Course in months:");
//        int duration = scanner.nextInt();
//
//
//        System.out.print("Enter Fees of the Course:");
//        double fees = scanner.nextDouble();
//        scanner.nextLine();
//
//        int id = random.nextInt(1, 101);
//
//        while (isCourseIdPresent(id)) {
//            id = random.nextInt(1, 101);
//        }
//
//        Course course = new Course(id, name, duration, fees);
//
//        return course;
//    }
//
//    private static boolean isCourseIdPresent(int id) {
//        for (Course courses : courseList) {
//            if (courses == null) {
//                break;
//            } else {
//                if (courses.getId() == id) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private static Student createStudent() {
//
//        System.out.println("\nEnter Details----->");
//        System.out.print("Enter Student Name:");
//        String name = scanner.nextLine();
//
//        Course[] studentCourses = new Course[3];
//        displayAllCourses();
//
//        System.out.print("Enter the number of Courses you want to enter(max=3):");
//        int numOfCourses = scanner.nextInt();
//        System.out.println("Enter choices you want to enter:");
//        for (int i = 0; i < numOfCourses; i++) {
//            System.out.print("Enter Course " + (i + 1) + " :");
//            int choice = scanner.nextInt();
//            studentCourses[i] = courseList[choice - 1];
//        }
//
//        double totalFees = 0;
//
//        for (Course course : studentCourses) {
//            if (course == null) {
//                break;
//            }
//            totalFees += course.getFees();
//        }
//        int id = random.nextInt(1, 101);
//
//        while (isStudentIdPresent(id)) {
//            id = random.nextInt(1, 101);
//        }
//
//
//        System.out.print("Enter paid Fees:");
//        double paidFees = scanner.nextDouble();
//
//        while (true) {
//            if (paidFees <= 0) {
//                System.out.print("Enter valid amount:");
//                paidFees = scanner.nextInt();
//
//            } else if (paidFees > totalFees) {
//                System.out.print("Enter equal or less than payable amount:");
//                paidFees = scanner.nextInt();
//            } else {
//                break;
//            }
//        }
//        scanner.nextLine();
//
//        Student student0 = new Student(id, name, studentCourses, paidFees, totalFees);
//
//        return student0;
//    }
//
//    private static boolean isStudentIdPresent(int id) {
//        for (Student student : studentList) {
//            if (student == null) {
//                break;
//            } else {
//                if (student.getId() == id) {
//                    return true;
//                }
//            }
//        }
//        return false;
//
//    }
//}
