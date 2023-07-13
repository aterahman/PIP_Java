package Banking_application.Banking_Exceptions.Account_Creation_related;

public class ValidateBalance
{
    public void ValidateBalance(long balance)throws BalanceException
    {
        if(balance<0)
        {
            throw new BalanceException("Balance cannot be negative");
        }
    }
}
