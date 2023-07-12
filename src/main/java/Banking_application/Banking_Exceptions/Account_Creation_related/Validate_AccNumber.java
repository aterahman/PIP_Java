package Banking_application.Banking_Exceptions.Account_Creation_related;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import java.io.*;

public class Validate_AccNumber
{
    public void Validate_AccNumber(String acc_number)throws IOException, AccNumberException
    {
        if(acc_number.length()==10)
        {
                File acc_data_csv = new File("src\\main\\resources\\accounts.csv");

                //using a reader that will read from file
                Reader file_read = new FileReader(acc_data_csv);

                //parsing the data that has been read
                CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(file_read);


                //CHECKING IF ACCOUNT NUMBER ALREADY EXISTS
                for (CSVRecord record : parser) {
                    String acc_number_in_csv = record.get(0);

                    if (acc_number_in_csv.equals(acc_number)) {
                        throw new AccNumberException("Account number already exists!");
                    }

                }
            }
            else
                throw new AccNumberException("Account number should be of 10 digits");


    }
}
