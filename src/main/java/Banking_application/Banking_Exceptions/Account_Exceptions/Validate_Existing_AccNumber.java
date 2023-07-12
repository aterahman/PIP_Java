package Banking_application.Banking_Exceptions.Account_Exceptions;

import Banking_application.Banking_Exceptions.Account_Creation_related.AccNumberException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

public class Validate_Existing_AccNumber
{
    public void Validate_AccNumber(String acc_number)throws ExistingAccNumberException, FileNotFoundException, IOException
    {
        File acc_data_csv = new File("src\\main\\resources\\accounts.csv");
        boolean found = false;

        //using a reader that will read from file
        Reader file_read = new FileReader(acc_data_csv);

        //parsing the data that has been read
        CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(file_read);


        //CHECKING IF ACCOUNT NUMBER ALREADY EXISTS
        for (CSVRecord record : parser)
        {
            String acc_number_in_csv = record.get(0);

            if (acc_number_in_csv.equals(acc_number)) {
               found = true;
            }

            if(found == false)
            {
                throw new ExistingAccNumberException("Account does not exist!");
            }

        }

    }

}
