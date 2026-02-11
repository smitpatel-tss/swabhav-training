package com.tss.LibraryManagement;
import static com.tss.utils.GlobalConstants.scanner;
import static com.tss.utils.Validate.*;

public class LibraryApp {
    static Library myLibrary=new Library();
    public static void main(String[] args) {
        while(true){
            displayMenu();
            System.out.print("Choose Option From Menu: ");
            int choice=validatePositiveInt();

            while(choice<1||choice>8){
                System.out.print("Choose valid Option: ");
                choice=validatePositiveInt();
            }
            scanner.nextLine();

            switch (choice){
                case 1:
                    myLibrary.addBook();
                    break;
                case 2:
                    myLibrary.addMember();
                    break;
                case 3:
                    myLibrary.borrowBook();
                    break;
                case 4:
                    myLibrary.displayBooks(myLibrary.books);
                    break;
                case 5:
                    myLibrary.displayMembers();
                    break;
                case 6:
                    myLibrary.displayBooksBorrowedByMember();
                    break;
                case 7:
                    myLibrary.searchBorrower();
                    break;
                case 8:
                    System.out.println("EXITING...");
                    return;
            }
        }
    }
    private static void displayMenu(){
        System.out.println("\n-----Main Menu-----");
        System.out.println("1. Add Book");
        System.out.println("2. Add Member");
        System.out.println("3. Borrow Book");
        System.out.println("4. Display All Books");
        System.out.println("5. Display All Members");
        System.out.println("6. Display Books Borrowed by Member");
        System.out.println("7. Display Borrower of Book");
        System.out.println("8. Exit");

    }
}
