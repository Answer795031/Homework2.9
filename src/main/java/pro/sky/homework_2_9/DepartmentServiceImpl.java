package pro.sky.homework_2_9;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    // метод для поиска сотрудника с наибольшей з/п в отделе
    @Override
    public Employee findMaxSalary(Integer departmentId) {

        return employeeService.findAll()
                .stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Ошибка! Сотрудник не найден!"));
    }

    // метод для поиска сотрудника с наименьшей з/п в отделе
    @Override
    public Employee findMinSalary(Integer departmentId) throws EmployeeNotFoundException{
        return employeeService.findAll()
                .stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Ошибка! Сотрудник не найден!"));
    }

    // метод для поиска всех сотрудников в отделе
    @Override
    public Collection<Employee> findAll(Integer departmentId) {
        return employeeService.findAll()
                .stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    // метод для поиска всех сотрудников с группировкой по отделам
    @Override
    public Map<Integer, List<Employee>> findAll(){
        return employeeService.findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
