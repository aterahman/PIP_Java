package Student_Information_System_Main_Assignment.Exceptions.Registration_related_exceptions;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

public class Validate_Registration
{
    //checking if username exists in records
    public void Validate_Username_Existence(String username)throws RegistrationException, FileNotFoundException, IOException
    {
        File acc_data_csv = new File("src\\main\\resources\\Student_Information_System_Resources\\Login_Details.csv");

        //using a reader that will read from file
        Reader file_read = new FileReader(acc_data_csv);

        //parsing the data that has been read
        CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(file_read);


        //CHECKING IF USERNAME ALREADY EXISTS
        for (CSVRecord record : parser) {
            String username_in_csv = record.get(1);

            if (username_in_csv.equals(username)) {
                throw new RegistrationException("Username already exists!");
            }

        }
    }

    public void Validate_Username_requirements(String Username)throws RegistrationException
    {
        for(int i=0;i<Username.length();i++)
        {
            char ch = Username.charAt(i);

            if(Character.isWhitespace(ch))
            {
                throw new RegistrationException("Username cannot have space");
            }
            else if(Character.isDigit(ch)==false && Character.isLetter(ch)==false)
            {
                throw new RegistrationException("Username cannot have special characters");
            }
        }
    }

    //checking if password exists in record
    public void Validate_Password_existence(String password)throws RegistrationException, FileNotFoundException, IOException
    {
        File acc_data_csv = new File("src\\main\\resources\\Student_Information_System_Resources\\Login_Details.csv");

        //using a reader that will read from file
        Reader file_read = new FileReader(acc_data_csv);

        //parsing the data that has been read
        CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(file_read);


        //CHECKING IF PASSWORD ALREADY EXISTS
        for (CSVRecord record : parser) {
            String password_in_csv = record.get(2);

            if (password_in_csv.equals(password)) {
                throw new RegistrationException("Password already exists!");
            }

        }
    }

    public void Validate_Password_Requirements(String password)throws RegistrationException
    {
        int upper_case=0, lower_case=0, special_character=0, digit=0;

        //checking if password is atleast 8 charcters long
        if(password.length()<8)
        {
            throw new RegistrationException("Password too small!");
        }
        else
        {
            for(int i=0;i<password.length();i++)
            {
                char ch = password.charAt(i);

                if(!Character.isWhitespace(ch))
                {
                    if(Character.isLetter(ch))
                    {
                        if(Character.isUpperCase(ch))
                        {
                            upper_case++;
                        }
                        else
                        {
                            lower_case++;
                        }
                    }
                    else if (Character.isDigit(ch))
                    {
                        digit++;
                    }
                    else
                    {
                        special_character++;
                    }
                }
                else
                {
                    throw new RegistrationException("Space cannot be present in password!");
                }
            }

            if(upper_case==0 || lower_case==0|| digit==0 || special_character==0)
            {
                throw new RegistrationException("Password does not meet requirements!");
            }
        }
    }
}
