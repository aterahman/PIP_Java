package Banking_application.Banking_Exceptions.Transaction_exceptions;

public class WithdrawalException extends Exception{
    public WithdrawalException(String errorMessage)
    {
        super(errorMessage);
    }
}
