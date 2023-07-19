package Student_Information_System_Main_Assignment.User_interface;

import Student_Information_System_Main_Assignment.Exceptions.Student_details_related.Validate_roll_no_existence;

import java.io.IOException;
import java.util.Scanner;

public class User_Interface_Screen {

    public String Enter_Roll_No() throws IOException {
        Scanner sc = new Scanner(System.in);
        Validate_roll_no_existence validateRollNoExistence = new Validate_roll_no_existence();

        //entering roll number
        System.out.println("Enter The Student's Roll Number");
        String roll_no = sc.next();

        //checking if roll number exists
        try {
            validateRollNoExistence.validate(roll_no);
        }
        catch (Exception e)
        {
            System.out.println("Exception occured : "+e);
            System.exit(-1);
        }

        return roll_no;
    }

    public void User_Interface_Screen() throws IOException {
        Scanner sc = new Scanner(System.in);
        Add_Student_Details addStudentDetails = new Add_Student_Details();
        Search_Student_Details searchStudentDetails = new Search_Student_Details();
        Delete_Student_Details deleteStudentDetails = new Delete_Student_Details();

        int choice;

        do {
        System.out.println("-------------------------------------------------------");
        System.out.println("Welcome User! What would you like to do today?");
        System.out.println("1. Add Student Details\n2. Search Student Details\n3. Update Student Details\n4. Delete Student Details\n5. Logout");
        System.out.println("-------------------------------------------------------");

        //entering choice
         choice = sc.nextInt();


            switch (choice) {
                case 1 -> {
                    addStudentDetails.Add_details();
                }
                case 2 -> {

                   String roll_number = Enter_Roll_No();
                   searchStudentDetails.Search_Details(roll_number);
                }
                case 3 ->{
                    String roll_number = Enter_Roll_No();

                }
                case 4 -> {
                    String roll_number = Enter_Roll_No();
                    System.out.println("Are you sure you want to delete?(Y/N)");
                    char ch = sc.next().charAt(0);
                    switch (Character.toUpperCase(ch)) {
                        case 'Y' -> deleteStudentDetails.Delete_Student_Details(roll_number);
                        case 'N' -> {
                            System.out.println("No data deleted!");
                            User_Interface_Screen();
                        }
                        default -> {
                            System.out.println("Invalid choice");
                            User_Interface_Screen();
                        }
                    }
                }
                case 5 ->
                {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default ->
                {
                    System.out.println("Invalid Choice");
                    User_Interface_Screen();
                }
            }
        }
        while (choice!=5);
    }
}
