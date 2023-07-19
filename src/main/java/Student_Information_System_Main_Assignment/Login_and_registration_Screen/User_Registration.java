package Student_Information_System_Main_Assignment.Login_and_registration_Screen;

import Student_Information_System_Main_Assignment.Exceptions.Registration_related_exceptions.Validate_Registration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class User_Registration
{
    //method to take user details input
    public void new_user_Registration()
    {
        Scanner sc = new Scanner(System.in);
        Validate_Registration validateRegistration = new Validate_Registration();

        //entering name
        System.out.println("Enter Name");
        String name = sc.nextLine();

        //entering username
        System.out.println("Enter Username");
        String username = sc.nextLine();

        //checking if username already exists and if it meets requirements
        try {
            validateRegistration.Validate_Username_Existence(username);
            validateRegistration.Validate_Username_requirements(username);
        }
        catch (Exception e)
        {
            System.out.println("Exception occurred : " + e);
            System.exit(-1);
        }

        //entering password
        System.out.println("Enter Password (Should have at least 1 Upper-case, 1 Lower-case, 1 digit, 1 special character and should be of at least 8 characters long");
        String password = sc.next();

        //checking if password is already taken and if it meets the requirements
        try{
            validateRegistration.Validate_Password_existence(password);
            validateRegistration.Validate_Password_Requirements(password);
        }
        catch (Exception e)
        {
            System.out.println("Exception occurred : "+ e);
            System.exit(-1);
        }

        //re-entering password
        System.out.println("Re-enter Password");
        String re_password = sc.next();

        //checking if the re-entered password is the same
        if(password.equals(re_password))
        {
            //storing in records if the passwords match
            record_entry(name,username,password);

            //Congratulatory method
            System.out.println("Account successfully created!");
        }
        else
        {
            //asking user to re-enter details if passwords do not match
            System.out.println("Sorry passwords do not match, enter details again");
            new_user_Registration();
        }

    }

    //method to store the entered details in csv
    public void record_entry(String name,String username, String password)
    {
        try
        {
            File file = new File("src\\main\\resources\\Student_Information_System_Resources\\Login_Details.csv");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(name+","+username+","+password);
            pw.flush();
            pw.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
