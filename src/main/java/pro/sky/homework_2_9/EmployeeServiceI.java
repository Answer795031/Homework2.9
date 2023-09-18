package pro.sky.homework_2_9;

import java.util.Collection;

public interface EmployeeServiceI {

    void EmployeeService() throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;

    Employee addNewEmployee(String fullName, int passportNumber)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;

    Employee removeEmployee(String fullName, int passportNumber)
            throws EmployeeNotFoundException;

    Employee findEmployee(String fullName, int passportNumber)
            throws EmployeeNotFoundException;

    Collection<Employee> findAll();
}
