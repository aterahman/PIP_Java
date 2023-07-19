package Student_Information_System_Main_Assignment.Exceptions.Student_details_related;

import Student_Information_System_Main_Assignment.Exceptions.Registration_related_exceptions.RegistrationException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Validate_Added_Roll_Number
{
    public void validate_added_roll_no(String roll_no)throws RollNumberException, IOException
    {
        File acc_data_csv = new File("src\\main\\resources\\Student_Information_System_Resources\\Student_Details.csv");

        //using a reader that will read from file
        Reader file_read = new FileReader(acc_data_csv);

        //parsing the data that has been read
        CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(file_read);


        //CHECKING IF ACCOUNT NUMBER ALREADY EXISTS
        for (CSVRecord record : parser) {
            String roll_no_in_csv = record.get(0);

            if (roll_no_in_csv.equals(roll_no)) {
                throw new RollNumberException("Roll No. already exists!");
            }

        }
    }
}
