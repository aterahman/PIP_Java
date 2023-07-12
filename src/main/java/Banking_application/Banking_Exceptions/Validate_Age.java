package Banking_application.Banking_Exceptions;

public class Validate_Age
{
    public void Validate_Age(int age)throws AgeException
    {
        if(age<18)
        {
            throw new AgeException("Customer is a minor. Account cannot be created.");
        }
    }
}
