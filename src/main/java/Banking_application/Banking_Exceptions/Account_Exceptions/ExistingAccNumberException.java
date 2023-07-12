package Banking_application.Banking_Exceptions.Account_Exceptions;

public class ExistingAccNumberException extends Exception
{
    public ExistingAccNumberException(String errorMessage)
    {
        super(errorMessage);
    }
}
