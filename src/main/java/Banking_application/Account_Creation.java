package Banking_application;
import java.io.*;
import java.util.*;

import Banking_application.Banking_Exceptions.Account_Creation_related.Validate_AccNumber;
import Banking_application.Banking_Exceptions.Account_Creation_related.Validate_Age;

//class to create a new Bank account
public class Account_Creation
{
    //Method to take user details to create new account
    public void Acc_Creation()
    {
        Scanner sc = new Scanner(System.in);
        Validate_Age validateAge = new Validate_Age();
        Validate_AccNumber validate_accNumber = new Validate_AccNumber();

        //Entering Account Number
        System.out.print("Enter 10-digit Account No: ");
        String acc_no = sc.next();

        //Validating entered account number
        try
        {
            validate_accNumber.Validate_AccNumber(acc_no);
        }
        catch (Exception e)
        {
            System.out.println("Exception occured: " + e + " Please restart process!");
            System.exit(-1);
        }

        //Entering account type
        System.out.print("Enter Account type: ");
        String acc_type = sc.next();

        //Entering Name
        System.out.print("Enter Name: ");
        String name = sc.next();

        //Entering age
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        //Validating enteredd age
        try
        {
            validateAge.Validate_Age(age);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
        String user_age = Integer.toString(age);

        //Entering starting bank balance
        System.out.print("Enter Balance: ");
        long balance = sc.nextLong();
        String Bank_Balance = Long.toString(balance);

        SaveRecord(acc_no,acc_type,name,user_age,Bank_Balance);

    }

    //Method to enter the data into the CSV file with all accounts' details
    public void SaveRecord(String acc_number, String acc_type, String Name ,String age, String Balance)
    {
        try
        {
            File file = new File("src\\main\\resources\\accounts.csv");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(acc_number+","+acc_type+","+Name+","+age+","+Balance);
            pw.flush();
            pw.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
