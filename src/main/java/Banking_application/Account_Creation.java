package Banking_application;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

import Banking_application.Banking_Exceptions.Account_Creation_related.Validate_AccNumber;
import Banking_application.Banking_Exceptions.Account_Creation_related.Validate_Age;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

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
        account_transaction_record_creation(acc_no, Bank_Balance);

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

    //method to create a record for the account created and to log future transactions
    public void account_transaction_record_creation(String acc_number, String first_transaction)
    {
        //setting the path adn the file name for the csv filw
        String outputFilePath = "src\\main\\resources\\" + acc_number + "Transaction-History.csv";

        String date = new SimpleDateFormat("dd-MM-YYYY-HH-mm-ss").format(new java.util.Date());
        //setting headers for the CSV file
        String [] csvHeader = {"Transaction date", "Transaction Amount", "Transaction Type", "Closing Balance"};

        //Creating a CSV file with the first transaction
        try (CSVPrinter csvPrinter = CSVFormat.DEFAULT.withHeader(csvHeader)
                .print(Paths.get(outputFilePath), Charset.forName("UTF-8"))) {
            csvPrinter.printRecord(date,first_transaction , "Credit",first_transaction);

            csvPrinter.flush();
            csvPrinter.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
