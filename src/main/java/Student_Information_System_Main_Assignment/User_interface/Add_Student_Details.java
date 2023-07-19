package Student_Information_System_Main_Assignment.User_interface;

import Student_Information_System_Main_Assignment.Exceptions.Student_details_related.Validate_Added_Roll_Number;

import java.io.*;
import java.util.Scanner;

public class Add_Student_Details
{
    //method to enter student details
    public void Add_details() throws IOException {
        Scanner sc = new Scanner(System.in);
        Validate_Added_Roll_Number validateAddedRollNumber = new Validate_Added_Roll_Number();

        //entering name
        System.out.println("Enter Student Name");
        String student_name = sc.next();

        //entering roll number
        System.out.println("Enter Roll Number");
        String roll_no = sc.next();

        try {
            validateAddedRollNumber.validate_added_roll_no(roll_no);
        }
        catch (Exception e)
        {
            System.out.println("Exception occurred : "+e);
            System.out.println("Please enter details again");
            Add_details();
        }


        //entering student age
        System.out.println("Enter Age");
        int age = sc.nextInt();

        //entering student course
        System.out.println("Enter Course");
        String course = sc.next();

        //entering student grade
        System.out.println("Enter Grade");
        String grade = sc.next();

        record_entry(student_name, roll_no, Integer.toString(age), course, grade);
    }

    //method to enter the student details into csv
    public void record_entry(String name, String roll_no, String age, String course, String grade) throws IOException
    {

        File file = new File("src\\main\\resources\\Student_Information_System_Resources\\Student_Details.csv");
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println(roll_no+","+name+","+age+","+course+","+grade);
        pw.flush();
        pw.close();

    }

}
