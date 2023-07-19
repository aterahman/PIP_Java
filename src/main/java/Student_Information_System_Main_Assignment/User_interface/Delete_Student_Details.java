package Student_Information_System_Main_Assignment.User_interface;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Delete_Student_Details
{
    //method to delete data based on roll no. enterred
    public void Delete_Student_Details(String roll_number_to_remove)
    {
        //storing the data temporarily in lists and then shifting them to a new file with same name

        String filepath = "src\\main\\resources\\Student_Information_System_Resources\\Student_Details.csv";

        File csvfile = new File(filepath);


        //list to temporarily store role number
        List<String> temp_roll_no_list = new ArrayList<>();

        //list to temporarily store name
        List<String> temp_name_list = new ArrayList<>();

        //list to temporarily store age
        List<String> temp_age_list = new ArrayList<>();

        //list to temporarily store course
        List<String> temp_course_list = new ArrayList<>();

        //list to temporarily store list
        List<String> temp_grade_list = new ArrayList<>();

        String student_name="",student_roll_number="",age="",course="",grade="";


        //storing all the values temporarily in their respective lists
        try
        {
            Scanner sc = new Scanner(csvfile);
            sc.useDelimiter(",|\n");

            while (sc.hasNext())
            {
                student_roll_number = sc.next();
                student_name= sc.next();
                age= sc.next();
                course= sc.next();
                grade= sc.next();

                //writing data into temporary file
                if(!student_roll_number.equals(roll_number_to_remove))
                {
                  temp_roll_no_list.add(student_roll_number);
                  temp_name_list.add(student_name);
                  temp_age_list.add(age);
                  temp_course_list.add(course);
                  temp_grade_list.add(grade);
                }

            }
            sc.close();
            csvfile.delete();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //printing the temporary list items into new file after removing the data
        try (CSVPrinter csvPrinter = CSVFormat.DEFAULT
                .print(Paths.get(filepath), Charset.forName("UTF-8"))) {
            for(int i=0;i< temp_roll_no_list.size();i++)
            {
                csvPrinter.printRecord((temp_roll_no_list.get(i)+","+temp_name_list.get(i)+","+temp_age_list.get(i)+","+temp_course_list.get(i)+","+(temp_grade_list.get(i).replace('"',' ')).trim()).split(",|\n"));
            }

            csvPrinter.flush();
            csvPrinter.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Student details successfully deleted!");
    }
}
