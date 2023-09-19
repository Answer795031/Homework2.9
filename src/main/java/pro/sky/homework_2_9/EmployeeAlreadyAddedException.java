package pro.sky.homework_2_9;

public class EmployeeAlreadyAddedException extends RuntimeException{

    public EmployeeAlreadyAddedException(String message){
        super(message);
    }
}