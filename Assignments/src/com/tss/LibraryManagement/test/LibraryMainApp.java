package com.tss.LibraryManagement.test;
import com.tss.LibraryManagement.service.LibraryService;

import static com.tss.utils.GlobalConstants.scanner;
import static com.tss.utils.Validate.*;

public class LibraryMainApp {
    static LibraryService myLibraryService =new LibraryService();
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
                    myLibraryService.addBook();
                    break;
                case 2:
                    myLibraryService.addMember();
                    break;
                case 3:
                    myLibraryService.borrowBook();
                    break;
                case 4:
                    myLibraryService.displayBooks(myLibraryService.getAllBooks());
                    break;
                case 5:
                    myLibraryService.displayMembers();
                    break;
                case 6:
                    myLibraryService.displayBooksBorrowedByMember();
                    break;
                case 7:
                    myLibraryService.searchBorrower();
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
