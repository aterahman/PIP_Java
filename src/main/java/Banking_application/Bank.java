package Banking_application;


import java.util.Scanner;

public class Bank
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice;
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
                case 1 -> {
                    //creating a new account
                    accountCreation.Acc_Creation();
                }
                case 2 ->
                {
                    //entering account number and checking if it exists
                    account.validate_accnumber();

                    //asking the user what they want to check
                    System.out.println("Do you want to get:\n1. Account Balance\n2. Transaction History");
                    int ch = sc.nextInt();
                    switch (ch)
                        {
                            //getting account balance
                            case 1: account.get_account_balance();
                                    break;
                            //getting the transaction history of the enterred account number
                            case 2: account.get_account_transaction_history();
                                    break;
                            default: System.out.println("Invalid Input");
                                    break;
                        }

                }
            }

        }
        while (choice!=6);


    }
}
