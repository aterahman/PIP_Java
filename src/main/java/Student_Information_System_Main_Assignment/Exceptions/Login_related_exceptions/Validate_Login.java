package Student_Information_System_Main_Assignment.Exceptions.Login_related_exceptions;

import Student_Information_System_Main_Assignment.Exceptions.Registration_related_exceptions.RegistrationException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

public class Validate_Login
{
    public void Validate_Username(String username) throws LoginException, FileNotFoundException, IOException
    {

        File acc_data_csv = new File("src\\main\\resources\\Student_Information_System_Resources\\Login_Details.csv");

        //using a reader that will read from file
        Reader file_read = new FileReader(acc_data_csv);

        //parsing the data that has been read
        CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(file_read);

        boolean found = false;

        //CHECKING IF USERNAME EXISTS
        for (CSVRecord record : parser) {
            String password_in_csv = record.get(1);

            if (password_in_csv.equals(username)) {
                found = true;
            }
        }

        if(found==false)
        {
            throw new LoginException("Incorrect username");
        }
    }

    public void Validate_Password(String password) throws LoginException, FileNotFoundException , IOException
    {
        File acc_data_csv = new File("src\\main\\resources\\Student_Information_System_Resources\\Login_Details.csv");

        //using a reader that will read from file
        Reader file_read = new FileReader(acc_data_csv);

        //parsing the data that has been read
        CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(file_read);

        boolean found = false;

        //CHECKING IF PASSWORD EXISTS
        for (CSVRecord record : parser) {
            String password_in_csv = record.get(2);

            if (password_in_csv.equals(password)) {
                found = true;
            }
        }

        if(found==false)
        {
            throw new LoginException("Incorrect password");
        }
    }
}
