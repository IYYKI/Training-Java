package Day10_7_25周四.正数;

public class InvalidInputException extends ArithmeticException{
    public InvalidInputException(){
        super("You must enter positive number");
    }

}
