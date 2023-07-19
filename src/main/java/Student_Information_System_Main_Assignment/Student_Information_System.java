package Student_Information_System_Main_Assignment;

import Student_Information_System_Main_Assignment.Login_and_registration_Screen.User_Login;
import Student_Information_System_Main_Assignment.Login_and_registration_Screen.User_Registration;
import Student_Information_System_Main_Assignment.User_interface.User_Interface_Screen;

import java.io.IOException;
import java.util.Scanner;

public class Student_Information_System {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        User_Registration userRegistration = new User_Registration();
        User_Login userLogin = new User_Login();
        User_Interface_Screen userInterfaceScreen = new User_Interface_Screen();

        int choice;
        do {

        System.out.println("-----*** WELCOME TO STUDENT INFORMATION SYSTEM ***-----");
        System.out.println("1. Register\n2. Login\n3. Exit");
        System.out.println("-------------------------------------------------------");
        System.out.println("Enter choice!");
        choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    userRegistration.new_user_Registration();
                    break;
                }
                case 2 -> {
                    userLogin.login();
                    userInterfaceScreen.User_Interface_Screen();
                    break;
                }
                case 3 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                }
                default -> {
                    System.out.println("Invalid choice");
                    break;
                }
            }
        }
        while (choice!=3);
    }
}
