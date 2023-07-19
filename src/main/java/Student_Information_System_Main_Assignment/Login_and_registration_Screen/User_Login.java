package Student_Information_System_Main_Assignment.Login_Screen;

import Student_Information_System_Main_Assignment.Exceptions.Login_related_exceptions.Validate_Login;

import java.util.Scanner;

public class User_Login
{
    public void login()
    {
        Scanner sc = new Scanner(System.in);
        Validate_Login validateLogin = new Validate_Login();

        //entering username
        System.out.println("Enter Username");
        String username = sc.next();

        //entering password
        System.out.println("Enter Password");
        String password = sc.next();

        //checking if the username and password exits in records
        try
        {
            validateLogin.Validate_Username(username);
            validateLogin.Validate_Password(password);
        }
        catch (Exception e)
        {
            System.out.println("Exception occured : " + e);
            System.out.println("Please try again");
            login();
        }

        System.out.println("Logged in successfully!");
    }
}
