package Banking_application;

import Banking_application.Banking_Exceptions.Account_Exceptions.Validate_Existing_AccNumber;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

public class Account
{
    public long account_balance;
    public String acc_number;
    public void validate_accnumber()
    {
        Scanner sc = new Scanner(System.in);
        Validate_Existing_AccNumber validateExistingAccNumber = new Validate_Existing_AccNumber();

        System.out.println("Enter 10 digit Account Number");
        String acc_num = sc.next();

        try
        {
            validateExistingAccNumber.Validate_AccNumber(acc_num);
        }
        catch (Exception e)
        {
            System.out.println("Exception occured: " + e + " Please restart process!");
            System.exit(-1);
        }

        this.acc_number = acc_num;
    }
    public void get_account_transaction_history()
    {

        String acc_balance = "";
        System.out.println("----***TRANSACTION HISTORY OF ACCOUNT NUMBER "+ acc_number+"***----");

        try {
            String file_path = "src\\main\\resources\\Accounts_Transactions\\" + acc_number + "-Transaction-History.csv";
            File file = new File(file_path);

            Reader filereader = new FileReader(file);

            CSVParser csvParser = CSVFormat.DEFAULT.withDelimiter(',').parse(filereader);

            for(CSVRecord record : csvParser )
            {

                System.out.println(record.get(0)+" | "+record.get(1)+" | "+record.get(2)+" | "+record.get(3));
                System.out.println("---------------------------------------------------------");

                acc_balance = record.get(3);
            }


        }
        catch (Exception e)
        {
            System.out.println("Exception occured: " + e + " Please restart process!");
            System.exit(-1);
        }
        System.out.println("Your closing account balance is : " + acc_balance);

    }

    public void get_account_balance()
    {
        String acc_balance = "";

        //getting account balance from the transaction history file
        try {
            String file_path = "src\\main\\resources\\Accounts_Transactions\\" + acc_number + "-Transaction-History.csv";
            File file = new File(file_path);

            Reader filereader = new FileReader(file);

            CSVParser csvParser = CSVFormat.DEFAULT.withDelimiter(',').parse(filereader);

            for(CSVRecord record : csvParser )
            {

                acc_balance = record.get(3);
            }


        }
        catch (Exception e)
        {
            System.out.println("Exception occured: " + e + " Please restart process!");
            System.exit(-1);
        }

        //prints the latest account balance
        System.out.println("Your account balance is : " + acc_balance);
        this.account_balance = Long.parseLong(acc_balance);
    }

}
