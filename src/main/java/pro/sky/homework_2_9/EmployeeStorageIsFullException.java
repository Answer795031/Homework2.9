package pro.sky.homework_2_9;

public class EmployeeStorageIsFullException extends Exception{

    public EmployeeStorageIsFullException(String message){
        super(message);
    }
}