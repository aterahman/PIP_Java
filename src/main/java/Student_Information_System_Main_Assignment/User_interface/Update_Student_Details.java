package Student_Information_System_Main_Assignment.User_interface;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Update_Student_Details
{
    //method to ask what value the user wants to update and take input
    public void user_prompt(String roll_number, String name, String age, String course, String grade) throws IOException {
        String roll_no = roll_number;
        String new_name="",new_age="",new_course="",new_grade="";

        Scanner sc = new Scanner(System.in);
        System.out.println("What detail do you want to update?");
        System.out.println("1. Name\n2. Age\n3. Course\n4. Grade");
        int ch = sc.nextInt();

        //taking user input for new value
        System.out.println("Enter new value");
        String new_value = sc.next();

        switch (ch)
        {
            //if user chooses to update name
            case 1 -> {

                new_name = new_value;
                new_age=age;
                new_course=course;
                new_grade=grade;
            }

            //if user chooses to update age
            case 2 -> {
                new_name = name;
                new_age=new_value;
                new_course=course;
                new_grade=grade;
            }

            //if user chooses to update course
            case 3 -> {
                new_name = name;
                new_age=age;
                new_course=new_value;
                new_grade=grade;
            }

            //if user chooses to update grade
            case 4 -> {
                new_name = name;
                new_age=age;
                new_course=course;
                new_grade=new_value;
            }

            default -> {
                System.out.println("Invalid choice");
                System.exit(-1);
            }
        }

        //sending the new values to the next method
        Update_Details(roll_no,new_name,new_age,new_course,new_grade);
    }

    //,ethod that will update data based on the user prompt from previous method
    public void Update_Details(String roll_no_to_update, String new_name, String new_age, String new_course, String new_grade) throws IOException
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

                //if the roll numbers match, then the new data is written into list
                if(student_roll_number.equals(roll_no_to_update))
                {
                    temp_roll_no_list.add(student_roll_number);
                    temp_name_list.add(new_name);
                    temp_age_list.add(new_age);
                    temp_course_list.add(new_course);
                    temp_grade_list.add(new_grade);

                }
                //if roll numbers donot match then old data is written into lists
                else
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
        System.out.println("Data Successfully Updated");
    }
}
