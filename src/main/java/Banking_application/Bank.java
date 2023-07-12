package Banking_application;
import java.util.Scanner;

public class Bank
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice=0;
        Account_Creation accountCreation = new Account_Creation();
        Account account = new Account();

        do {
            System.out.println("----------------------********************---------------------------");
            System.out.println("Hello! Welcome to the Banking Application! What would you like to do?");
            System.out.println("1. Create Bank Account\n2. Check Existing Account Details\n3. Withdraw Amount\n4. Deposit Amount\n5. Delete Account\n6. Exit");
            System.out.println("----------------------********************---------------------------");
            System.out.println("Please Enter Your Choice!");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1 :
                        accountCreation.Acc_Creation();
                         break;
                case 2 :
                        account.get_account_details();

            }

        }
        while (choice!=6);


    }
}
