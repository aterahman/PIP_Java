package Instructions_assignment;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Go_TO
{
    int file1_instrcutions,file2_instrcutions,file3_instrcutions;
    public void file_1()
    {
        try {
            File file1 = new File("src\\main\\resources\\Instructions_assignment\\file1.txt");
            Scanner sc = new Scanner(file1);
            sc.useDelimiter(",");
            String text = "";

            //Stores all the instructions inducidually after splitting
            ArrayList <String> instructions = new ArrayList<>();

            while (sc.hasNext())
            {
             text = sc.next();
             instructions.add(text.trim());
            }

            int initial_instructions_count = instructions.size();
            int duplicates_count =0;

            for(int i =0; i<(instructions.size()-1);i++)
            {
                for(int j = i+1;j<instructions.size();j++)
                {
                    if(((instructions.toArray())[i].equals((instructions.toArray())[j])))
                    {
                        duplicates_count++;
                    }
                }
            }

            //checking for the count after removing duplicates
            int instructions_without_duplicates = initial_instructions_count - duplicates_count;

            System.out.println("\nTotal instructions in File 1 = "+instructions.size());
            System.out.println("Instructions in File 1 after removing duplicates = "+instructions_without_duplicates);
            this.file1_instrcutions = instructions_without_duplicates;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void file_2()
    {
        try {
            File file2 = new File("src\\main\\resources\\Instructions_assignment\\file2.txt");
            Scanner sc = new Scanner(file2);
            sc.useDelimiter(",");
            String text = "";

            //Stores all the instructions inducidually after splitting
            ArrayList <String> instructions = new ArrayList<>();

            while (sc.hasNext())
            {
                text = sc.next();
                instructions.add(text.trim());
            }

            int initial_instructions_count = instructions.size();
            int duplicates_count =0;

            for(int i =0; i<(instructions.size()-1);i++)
            {
                for(int j = i+1;j<instructions.size();j++)
                {
                    if(((instructions.toArray())[i].equals((instructions.toArray())[j])))
                    {
                        duplicates_count++;
                    }
                }
            }

            //checking for the count after removing duplicates
            int instructions_without_duplicates = initial_instructions_count - duplicates_count;

            System.out.println("\nTotal instructions in File 2 = "+instructions.size());
            System.out.println("Instructions in File 2 after removing duplicates = "+instructions_without_duplicates);
            this.file2_instrcutions = instructions_without_duplicates;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void file_3()
    {
        try {
            File file3 = new File("src\\main\\resources\\Instructions_assignment\\file3.txt");
            Scanner sc = new Scanner(file3);
            sc.useDelimiter(",");
            String text = "";

            //Stores all the instructions inducidually after splitting
            ArrayList <String> instructions = new ArrayList<>();

            while (sc.hasNext())
            {
                text = sc.next();
                instructions.add(text.trim());
            }

            int initial_instructions_count = instructions.size();
            int duplicates_count =0;

            for(int i =0; i<(instructions.size()-1);i++)
            {
                for(int j = i+1;j<instructions.size();j++)
                {
                    if(((instructions.toArray())[i].equals((instructions.toArray())[j])))
                    {
                        duplicates_count++;
                    }
                }
            }

            //checking for the count after removing duplicates
            int instructions_without_duplicates = initial_instructions_count - duplicates_count;

            System.out.println("\nTotal instructions in File 3 = "+instructions.size());
            System.out.println("Instructions in File 3 after removing duplicates = "+instructions_without_duplicates);
            this.file3_instrcutions = instructions_without_duplicates;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //method to compare file count to see file with most instructions without duplicates
    public void compare()
    {
        int biggest=0;
        String biggest_file="";

        if(file1_instrcutions>file2_instrcutions && file1_instrcutions>file3_instrcutions)
        {
            biggest=file1_instrcutions;
            biggest_file="File1";
        }
        else if(file2_instrcutions>file1_instrcutions && file2_instrcutions>file3_instrcutions)
        {
            biggest=file2_instrcutions;
            biggest_file="File2";
        }
        else if(file3_instrcutions>file1_instrcutions && file3_instrcutions>file2_instrcutions)
        {
            biggest=file3_instrcutions;
            biggest_file="File3";
        }

        System.out.println("\nThe File with the most instructions without duplicates is : "+ biggest_file +" with "+biggest+" instructions");
    }

    public static void main(String [] args)
    {
        Go_TO go = new Go_TO();

        go.file_1();
        go.file_2();
        go.file_3();
        go.compare();
    }
}
