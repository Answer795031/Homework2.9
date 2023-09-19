package pro.sky.homework_2_9;

import java.util.Collection;

public interface EmployeeService {

    Employee addNewEmployee(String fullName, int passportNumber, int salary, int departmentId)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;

    Employee removeEmployee(String fullName, int passportNumber, int salary, int departmentId)
            throws EmployeeNotFoundException;

    Employee findEmployee(String fullName, int passportNumber, int salary, int departmentId)
            throws EmployeeNotFoundException;

    Collection<Employee> findAll();
}
