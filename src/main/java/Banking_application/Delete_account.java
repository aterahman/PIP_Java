package Banking_application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Delete_account
{
    public void remove_account(String acc_to_be_removed)
    {
        //creating aremporary file to store data while the account is being removed
        String temp_file = "temp.csv";

        String filepath = "src\\main\\resources\\accounts.csv";

        File csvfile = new File(filepath);

        File tempfile = new File(temp_file);

        String acc_num="",acc_type="",name="",age="",balance="";

        try
        {
            FileWriter fw = new FileWriter(temp_file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            Scanner sc = new Scanner(csvfile);
            sc.useDelimiter(",|\n");

            while (sc.hasNext())
            {
                acc_num= sc.next();
                acc_type= sc.next();
                name= sc.next();
                age= sc.next();
                balance= sc.next();

                //writing data into temporary file
                if(!acc_num.equals(acc_to_be_removed))
                {
                    pw.println(acc_num+","+acc_type+","+name+","+age+","+balance);
                }
            }
            sc.close();
            pw.flush();
            pw.close();
            csvfile.delete();
            File dump = new File(filepath);
            tempfile.renameTo(dump);
            tempfile.delete();
            System.out.println("Account deleted!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}