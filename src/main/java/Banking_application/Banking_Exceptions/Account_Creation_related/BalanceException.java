package Banking_application.Banking_Exceptions.Account_Creation_related;

public class BalanceException extends Exception
{
    public BalanceException(String errorMessage)
    {
        super(errorMessage);
    }
}
