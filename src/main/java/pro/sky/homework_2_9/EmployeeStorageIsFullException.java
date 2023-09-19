package pro.sky.homework_2_9;

public class EmployeeStorageIsFullException extends RuntimeException{

    public EmployeeStorageIsFullException(String message){
        super(message);
    }
}