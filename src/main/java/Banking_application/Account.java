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
    public void get_account_details()
    {
        Scanner sc = new Scanner(System.in);
        Validate_Existing_AccNumber validateExistingAccNumber = new Validate_Existing_AccNumber();

        System.out.println("Enter 10 digit Account Number");

        //Entering account number
        String acc_number = sc.next();

        //checking whether the account number exists in the records or not
        try
        {
            validateExistingAccNumber.Validate_AccNumber(acc_number);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(-1);
        }


        try {
            String file_path = "src\\main\\resources\\" + acc_number + "Transaction-History.csv";
            File file = new File(file_path);

            Reader filereader = new FileReader(file);

            CSVParser csvParser = CSVFormat.DEFAULT.withDelimiter(',').parse(filereader);

            for(CSVRecord record : csvParser )
            {
                System.out.println(record.get(0)+" | "+record.get(1)+" | "+record.get(2)+" | "+record.get(3));
                System.out.println("---------------------------------------------------------");
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

}
