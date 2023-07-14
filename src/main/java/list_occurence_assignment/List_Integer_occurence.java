package list_occurence_assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class List_Integer_occurence
{
    private Scanner sc;
    List <Integer> output_list;
    List <Integer> input_list;

    //method to take input list
    public void list_input()
    {
        sc = new Scanner(System.in);
        System.out.println("Enter list length");

        int length = sc.nextInt();

        List<Integer>elements_list = new ArrayList<>();

        //taking dynamic input for list
        System.out.println("Enter all elements to be entered into list");
        for(int i=0;i<length;i++)
        {
            int element = sc.nextInt();
            elements_list.add(element);
        }

        this.input_list = elements_list;
        System.out.println("The input list is : "+input_list);
    }

    //method to create a list with elements ocurring only once in the input list
    public void calculate_output_list()throws NullPointerException
    {
        System.out.println("\nCalculating output list");

        List<Integer>output_integer_list = new ArrayList<>();

        //list to store recurring values
        List<Integer>recurring_integers = new ArrayList<>();

        //checking if any integer is recurring in the input list
        for(int i=0;i<input_list.size();i++)
        {
            for(int j =i+1;j<input_list.size();j++)
            {
                //checking if integer at i is recurring by comparing with integer at j
                if(input_list.get(i)== input_list.get(j))
                {
                    //adding integer to recurring list if it is recurring
                    recurring_integers.add(input_list.get(i));
                }
            }

            //checking if the integer at i is recurring, adding to output list if not
            if(!recurring_integers.contains(input_list.get(i)))
            {
                output_integer_list.add(input_list.get(i));
            }
        }
        System.out.println("Output list calculated!");
        this.output_list = output_integer_list;
    }

    //method to display input and output list
    public void display_output()
    {
        System.out.println("\nInput list is :" + input_list);
        System.out.println("Output list is : "+output_list);
    }
    public static void main(String [] args)throws NullPointerException
    {
        List_Integer_occurence listIntegerOccurence = new List_Integer_occurence();
        listIntegerOccurence.list_input();
        listIntegerOccurence.calculate_output_list();
        listIntegerOccurence.display_output();
    }
}
