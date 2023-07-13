package Banking_application.Banking_Exceptions.Account_Exceptions;

import Banking_application.Banking_Exceptions.Account_Creation_related.AccNumberException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

public class Validate_Existing_AccNumber
{public void Validate_AccNumber(String acc_number)throws IOException, AccNumberException
{
    //checking if the number is of 10 digits
    if(acc_number.length()==10)
    {
        //initializing a variable to check igf account number exists
        boolean found = false;

        File acc_data_csv = new File("src\\main\\resources\\accounts.csv");

        //using a reader that will read from file
        Reader file_read = new FileReader(acc_data_csv);

        //parsing the data that has been read
        CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(file_read);


        //CHECKING IF ACCOUNT NUMBER ALREADY EXISTS
        for (CSVRecord record : parser) {
            String acc_number_in_csv = record.get(0);

            //validating entered account number with those in the csv record
            if (acc_number_in_csv.equals(acc_number)) {
                found=true;
                break;
            }

        }
        //checking if account number exists
        if (found==false)
        {
            throw new AccNumberException("Account does not exist!");
        }
    }
    else
        throw new AccNumberException("Account number should be of 10 digits");


}

}
