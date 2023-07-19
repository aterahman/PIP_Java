package Student_Information_System_Main_Assignment.Exceptions.Student_details_related;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

public class Validate_roll_no_existence
{
    public void validate(String roll_no) throws RollNumberException, IOException {
    File acc_data_csv = new File("src\\main\\resources\\Student_Information_System_Resources\\Student_Details.csv");

    //using a reader that will read from file
    Reader file_read = new FileReader(acc_data_csv);

    //parsing the data that has been read
    CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(file_read);

    boolean found = false;

    //CHECKING IF ACCOUNT NUMBER ALREADY EXISTS
        for (
    CSVRecord record : parser) {

    String roll_no_in_csv= record.get(0);

    if (roll_no_in_csv.equals(roll_no)) {
        found =true;
    }
}

        if(found == false)
    {
        throw new RollNumberException("Roll no. does not exist");
    }
}
}

