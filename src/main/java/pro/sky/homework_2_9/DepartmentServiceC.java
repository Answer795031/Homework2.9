package pro.sky.homework_2_9;

import org.springframework.stereotype.Service;

import java.util.*;
import javax.swing.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceC implements DepartmentServiceI{

    private final EmployeeServiceC employeeService;

    public DepartmentServiceC(EmployeeServiceC employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalary(Integer departmentId) throws EmployeeNotFoundException{

        return employeeService.findAll()
                .stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Ошибка! Сотрудник не найден!"));
    }

    @Override
    public Employee findMinSalary(Integer departmentId) throws EmployeeNotFoundException{
        return employeeService.findAll()
                .stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Ошибка! Сотрудник не найден!"));
    }

    @Override
    public Employee findAllByDepartment(Integer departmentId) {
        return (Employee) employeeService.findAll()
                .stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findAll(){
        return employeeService.findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));

    }
}
