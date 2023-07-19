package Student_Information_System_Main_Assignment.User_interface;

import Student_Information_System_Main_Assignment.Exceptions.Student_details_related.RollNumberException;
import Student_Information_System_Main_Assignment.Exceptions.Student_details_related.Validate_roll_no_existence;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.Scanner;

public class Search_Student_Details
{
    public String searched_name,searched_age,searched_course,searche_grade;

    public void Search_Details(String roll_no) throws IOException {
        File acc_data_csv = new File("src\\main\\resources\\Student_Information_System_Resources\\Student_Details.csv");

        //using a reader that will read from file
        Reader file_read = new FileReader(acc_data_csv);

        //parsing the data that has been read
        CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(file_read);


        //CHECKING IF ACCOUNT NUMBER ALREADY EXISTS
        for (CSVRecord record : parser) {

            String roll_no_in_csv= record.get(0);
            String name = record.get(1);
            String age = record.get(2);
            String course = record.get(3);
            String grade = record.get(4);

            //displaying the student details
            if (roll_no_in_csv.equals(roll_no)) {

                System.out.println("Name | Roll No. | Age | Course | Grade");
                System.out.println(name+" | "+roll_no_in_csv+" | "+age+" | "+course+" | "+grade);
                store_data(name,age,course,grade);
            }
        }
    }

    //storing data for other usage such as updating
    public void store_data(String name,String age, String course, String grade)
    {
        this.searched_name = name;
        this.searched_age=age;
        this.searched_course=course;
        this.searche_grade=grade;
    }
}
