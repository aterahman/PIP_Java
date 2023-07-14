package String__hashmap;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Char_recurrence_hashmap {
    private static Scanner sc;
    public static HashMap<Character, Integer> output_characters_map;

    //method to take string input
    public void String_Input()
    {
        //inputting string
        System.out.println("Enter the desired string :");
        String sentence = sc.nextLine();

        //sending string for map calculation, convertings everything to lowercase to reduce complications
        Calculate_hashmap(sentence.toLowerCase());
    }

    //method to calculate map
    public void Calculate_hashmap(String sentence) {

        //storing length of the string
        int length = sentence.length();

        //map to locally store output map
        HashMap<Character, Integer> outputmap = new HashMap<>();

        //list to store recurring characters to avoid double counting
        List<Character> recurring_characters = new ArrayList<>();

        char recurring_character = ' ';

        for (int i = 0; i < length; i++)
        {
            char char_at_i = sentence.charAt(i);
            int recurring_char_index = i;
            int count =0;

            //checking if the charcter is whitespace, skipping loop if it is
            if(Character.isWhitespace(char_at_i))
                continue;

            //checking if any element is already recurring so as to avoid double counting
            if (!recurring_characters.contains(char_at_i))
            {
                for (int j = i + 1; j < length; j++)
                {
                    char char_at_j = sentence.charAt(j);

                    //checking if the character is whitespace
                    if (!Character.isWhitespace(char_at_j))
                    {
                        //checking if the character is recurring
                            if (char_at_i == char_at_j)
                            {
                                recurring_character = char_at_i;

                                //value is sum of indexes for recurring characters
                                recurring_char_index = recurring_char_index + j;
                                count++;
                            }

                    }
                }
                if(count>0) {
                    //adding recurring character to list to avoid double counting
                    recurring_characters.add(recurring_character);

                    //adding character and sum of indexes to map
                    outputmap.put(recurring_character, recurring_char_index);

                }
                else
                    //adding non-recurring character and its index to map
                    outputmap.put(char_at_i,i);
            }
        }

        this.output_characters_map = outputmap;

    }

    public static void main(String args[])
    {
        sc = new Scanner(System.in);
        Char_recurrence_hashmap recurrenceHashmap = new Char_recurrence_hashmap();
        recurrenceHashmap.String_Input();
        System.out.println(output_characters_map);
    }
}
