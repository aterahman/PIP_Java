package Banking_application;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Transactions
{
    String acc_number;
    long acc_balance;

    //method to get account details such as account number and account balance from the account class
    public void getting_account_details()
    {
        Account account = new Account();
        account.validate_accnumber();
        account.get_account_balance();
        this.acc_balance = account.account_balance;
        this.acc_number = account.acc_number;
    }

    //method to enter amount to be withdrawn
    public void withdraw()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount you want to withdraw");
        long withdrawal_amt = sc.nextLong();
        long new_acc_balance = acc_balance-withdrawal_amt;
        System.out.println("Rs"+withdrawal_amt + " Withdrawn!");

        String date = new SimpleDateFormat("dd-MM-YYYY-HH-mm-ss").format(new java.util.Date());
        String new_balance = Long.toString(new_acc_balance);
        String amt_withdrawn = Long.toString(withdrawal_amt);
        try {
            record_withdrawal(date, amt_withdrawn, new_balance);
        }
        catch (Exception ignore)
        {}
    }

    //method to record the withdrawal transaction in csv
    public void record_withdrawal(String date,String withdrawal_amt, String new_balance)throws FileNotFoundException,IOException
    {

        try {
            String outputFilePath = "src\\main\\resources\\Accounts_Transactions\\" + acc_number + "-Transaction-History.csv";
            File file = new File(outputFilePath);
            FileWriter fileWriter = new FileWriter(file, true);
            CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT);
            csvPrinter.printRecord(date, withdrawal_amt, "Debit", new_balance);
            csvPrinter.flush();
        }
        catch (Exception ignore)
        {

        }

    }

    //method to take user input for the amount to be deposited
    public void deposit()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount you want to deposit");
        long deposited_amt = sc.nextLong();
        long new_acc_balance = acc_balance+deposited_amt;
        System.out.println("Rs"+deposited_amt + " Deposited!");

        String date = new SimpleDateFormat("dd-MM-YYYY-HH-mm-ss").format(new java.util.Date());
        String new_balance = Long.toString(new_acc_balance);
        String amt_deposited = Long.toString(deposited_amt);
        try
        {
            record_deposit(date,amt_deposited,new_balance);
        }
        catch (Exception ignore){}
    }

    //method to record the deposition transaction in csv
    public void record_deposit(String date,String deposited_amt, String new_balance)throws FileNotFoundException,IOException
    {

        try {
            String outputFilePath = "src\\main\\resources\\Accounts_Transactions\\" + acc_number + "-Transaction-History.csv";
            File file = new File(outputFilePath);
            FileWriter fileWriter = new FileWriter(file, true);
            CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT);
            csvPrinter.printRecord(date, deposited_amt, "Credit", new_balance);
            csvPrinter.flush();
        }
        catch (Exception ignore)
        {

        }

    }
}
