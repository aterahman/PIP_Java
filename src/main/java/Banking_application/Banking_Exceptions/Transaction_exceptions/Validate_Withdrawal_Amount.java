package Banking_application.Banking_Exceptions.Transaction_exceptions;

public class Validate_Withdrawal_Amount
{
    public void Validate_Withdrawal_Amount(long Amt,long balance)throws WithdrawalException
    {
        if(Amt > balance)
        {
            throw new WithdrawalException("You donot have sufficient funds");
        }

        if(Amt<0)
        {
            throw new WithdrawalException("Amount cannot be negative");
        }

    }
}
