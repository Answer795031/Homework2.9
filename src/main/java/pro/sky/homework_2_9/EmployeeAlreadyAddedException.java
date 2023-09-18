package pro.sky.homework_2_9;

public class EmployeeAlreadyAddedException extends Exception{

    public EmployeeAlreadyAddedException(String message){
        super(message);
    }
}