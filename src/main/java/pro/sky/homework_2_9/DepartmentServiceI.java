package pro.sky.homework_2_9;

import java.util.List;
import java.util.Map;

public interface DepartmentServiceI {

    Employee findMaxSalary(Integer departmentId) throws EmployeeNotFoundException;

    Employee findMinSalary(Integer departmentId) throws EmployeeNotFoundException;

    Employee findAllByDepartment(Integer departmentId);

    Map<Integer, List<Employee>> findAll();
}
