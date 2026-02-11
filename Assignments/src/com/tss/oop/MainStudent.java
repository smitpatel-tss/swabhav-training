package com.tss.oop;

import java.util.Scanner;
import java.util.Random;

public class MainStudent {
    static final Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static final int MAX_COURSES=5;
    static final int MAX_STUDENTS=10;
    static final Course[] courseList = new Course[MAX_COURSES];
    static final Student[] studentList = new Student[MAX_STUDENTS];
    static int totalStudents;
    static int totalCourses;

    public static void main(String[] args) {

        while (true) {
            System.out.print("Enter the number of Courses you want to enter (max=5):");
            totalCourses = scanner.nextInt();
            scanner.nextLine();
            if (totalCourses > 0 && totalCourses <= MAX_COURSES) break;
            System.out.println("Enter valid amount from 1 to 5");
        }

        for (int i = 0; i < totalCourses; i++) {
            System.out.println("\nEnter details for course " + (i + 1));
            courseList[i] = makeCourse();
        }

        while (true) {
            System.out.print("\nEnter Number of Student You Want to enter(max 10):");
            totalStudents = scanner.nextInt();
            if (totalStudents > 0 && totalStudents <= MAX_STUDENTS) break;
            System.out.println("Enter valid amount from 1 to 10");
        }
        scanner.nextLine();

        for (int i = 0; i < totalStudents; i++) {
            System.out.println("\nFor Student " + (i + 1));
            studentList[i] = createStudent();
        }

        while (true) {
            System.out.println("\n=====MAIN MENU=====");
            System.out.println("1. Add Student");
            System.out.println("2. Add new Course");
            System.out.println("3. Display Student Profile");
            System.out.println("4. Display all Students");
            System.out.println("5. Display all Courses");
            System.out.println("6. Pay Fees");
            System.out.println("7. View Pending Fees");
            System.out.println("8. Assign new Course to student");
            System.out.println("9. Exit");

            int choice;
            while (true) {
                System.out.print("Enter The Choice:");
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 9) break;
                System.out.println("Enter valid value from 1 to 9");
            }
            scanner.nextLine();

            switch (choice) {

                case 1:
                    if (totalStudents < MAX_STUDENTS) {
                        studentList[totalStudents] = createStudent();
                        totalStudents++;
                    }
                    break;

                case 2:

                    if(totalCourses==MAX_COURSES){
                        System.out.println("You Can't enter more than 5 courses!");
                    }
                    else{
                        courseList[totalCourses]=makeCourse();
                        totalCourses++;
                    }
                    break;

                case 3:
                    System.out.print("Enter student id :");
                    int idToDisplay = scanner.nextInt();
                    Student s1 = findStudentById(idToDisplay);
                    if (s1 == null) {
                        System.out.println("There is no Student with such ID!");
                    } else {
                        s1.displayProfile();
                    }
                    break;

                case 4:
                    displayAllStudents();
                    break;

                case 5:
                    displayAllCourses();
                    break;

                case 6:
                    System.out.print("Enter student id :");
                    int idToPayFees = scanner.nextInt();
                    Student st = findStudentById(idToPayFees);
                    if (st == null) {
                        System.out.println("There is no Student with such ID!");
                        break;
                    }

                    double remaining = st.getTotalFees() - st.getFeesPaid();
                    double fees;
                    while (true) {
                        System.out.print("Enter fees you want to pay:");
                        fees = scanner.nextDouble();
                        if (fees > 0 && fees <= remaining) break;
                        System.out.println("Enter valid payable amount");
                    }

                    st.setFeesPaid(st.getFeesPaid() + fees);
                    break;

                case 7:
                    System.out.print("Enter student id :");
                    int idForPendingFees = scanner.nextInt();
                    Student s2 = findStudentById(idForPendingFees);
                    if (s2 == null) {
                        System.out.println("There is no Student with such ID!");
                    } else {
                        System.out.println("Pending fees: " +
                                (s2.getTotalFees() - s2.getFeesPaid()));
                    }
                    break;

                case 8:
                    System.out.print("Enter student id :");
                    int idForCourseUpdate = scanner.nextInt();
                    Student s3 = findStudentById(idForCourseUpdate);
                    if (s3 == null) {
                        System.out.println("There is no Student with such ID!");
                    } else {
                        addNewSubject(s3);
                    }
                    break;

                case 9:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }

    private static Student findStudentById(int id) {
        for (Student s : studentList) {
            if (s == null) break;
            if (s.getId() == id) return s;
        }
        return null;
    }

    private static void addNewSubject(Student student) {
        for (int i = 0; i < student.getCourse().length; i++) {
            if (student.getCourse()[i] == null) {
                displayAllCourses();
                int courseNum;
                while (true) {
                    System.out.print("Enter the course you want to enter:");
                    courseNum = scanner.nextInt();
                    if (courseNum >= 1 && courseNum <= MAX_COURSES && courseList[courseNum - 1] != null) break;
                    System.out.println("Invalid course choice!");
                }
                while (true) {
                    if (student.canTakeCourse(courseList[courseNum - 1])) {
                        System.out.print("This course is already Opted.. Enter another: ");
                        courseNum = scanner.nextInt();
                    } else {
                        break;
                    }
                }
                student.getCourse()[i] = courseList[courseNum - 1];
                student.setTotalFees(student.getTotalFees() +
                        courseList[courseNum - 1].getFees());
                return;
            }
        }
        System.out.println("3 slots for Course is full!");
    }

    private static void displayAllStudents() {

        System.out.printf(
                "%-8s %-25s %-35s %15s %15s%n",
                "ID", "NAME", "COURSES", "FEES PAID", "TOTAL FEES"
        );

        System.out.println("-------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < totalStudents; i++) {
            if (studentList[i] == null) break;

            System.out.printf(
                    "%-8d %-25s %-35s %15.2f %15.2f%n",
                    studentList[i].getId(),
                    studentList[i].getName(),
                    getNameOfCourses(studentList[i]),
                    studentList[i].getFeesPaid(),
                    studentList[i].getTotalFees()
            );
        }
    }


    private static String getNameOfCourses(Student student) {
        String ans = "";
        for (Course c : student.getCourse()) {
            if (c == null) break;
            ans += c.getName() + " , ";
        }
        return ans;
    }

    private static void displayAllCourses() {
        for (int i = 0; i < courseList.length; i++) {
            if (courseList[i] == null) break;
            System.out.println((i + 1) + "------");
            courseList[i].displayCourse();
        }
    }

    private static boolean checkCourseName(String name){
        for(Course course:courseList){
            if(course==null){
                break;
            }
            if(course.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    private static Course makeCourse() {

        System.out.print("Enter name of the Course:");
        String name = scanner.nextLine();

        while(true){
            if(checkCourseName(name)){
                System.out.print("Course is already Available.. give different Name: ");
                name= scanner.nextLine();
            }else{
                break;
            }
        }

        int duration;
        while (true) {
            System.out.print("Enter Duration of the Course in months:");
            duration = scanner.nextInt();
            if (duration > 0) break;
            System.out.println("Enter positive duration");
        }

        double fees;
        while (true) {
            System.out.print("Enter Fees of the Course:");
            fees = scanner.nextDouble();
            if (fees > 0) break;
            System.out.println("Enter positive fees");
        }
        scanner.nextLine();

        int id;
        do {
            id = random.nextInt(1, 101);
        } while (isCourseIdPresent(id));

        return new Course(id, name, duration, fees);
    }

    private static boolean isCourseIdPresent(int id) {
        for (Course c : courseList) {
            if (c == null) break;
            if (c.getId() == id) return true;
        }
        return false;
    }

    private static Student createStudent() {

        System.out.print("Enter Student Name:");
        String name = scanner.nextLine();

        Course[] studentCourses = new Course[3];
        displayAllCourses();

        int num;
        while (true) {
            System.out.print("Enter the number of Courses you want to enter(max=3):");
            num = scanner.nextInt();
            if (num > 0 && num <= 3 && num<=totalCourses) break;
            System.out.println("Enter valid value!");
        }


        for (int i = 0; i < num; i++) {
            int choice;
            while (true) {
                System.out.print("Enter Course " + (i + 1) + ":");
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= MAX_COURSES && choice<=totalCourses) break;
                System.out.println("Invalid course choice");
            }
            boolean alreadyTaken;

            do {
                alreadyTaken = false;

                for (int j = 0; j < i; j++) {
                    if (studentCourses[j] == courseList[choice - 1]) {
                        alreadyTaken = true;
                        System.out.println("This course is already selected. Choose another.");
                        break;
                    }
                }

                if (alreadyTaken) {
                    System.out.print("Enter Course " + (i + 1) + ":");
                    choice = scanner.nextInt();
                }

            } while (alreadyTaken);

            studentCourses[i] = courseList[choice - 1];

            studentCourses[i] = courseList[choice - 1];
        }

        double totalFees = 0;
        for (Course c : studentCourses) {
            if (c == null) break;
            totalFees += c.getFees();
        }

        int id;
        do {
            id = random.nextInt(1, 101);
        } while (isStudentIdPresent(id));

        double paidFees;
        while (true) {
            System.out.print("Enter paid Fees:");
            paidFees = scanner.nextDouble();
            if (paidFees >= 0 && paidFees <= totalFees) break;
            System.out.println("Invalid fees amount");
        }
        scanner.nextLine();

        System.out.println("Student Created with ID: "+id);

        return new Student(id, name, studentCourses, paidFees, totalFees);
    }

    private static boolean isStudentIdPresent(int id) {
        for (Student s : studentList) {
            if (s == null) break;
            if (s.getId() == id) return true;
        }
        return false;
    }

}
