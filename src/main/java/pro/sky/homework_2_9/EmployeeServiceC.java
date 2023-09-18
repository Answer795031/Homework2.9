package pro.sky.homework_2_9;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceC implements EmployeeServiceI{

    private Map<String, Employee> employees;
    private static final int MAX_SIZE = 10; // максимум сотрудников

    public String employees(){
        return "Список сотрудников:\n" + employees;
    }

    @Override
    public void EmployeeService() throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        this.employees = new HashMap<>();

        addNewEmployee("Max Tarasov", 5017);
        addNewEmployee("Yulia Kalacheva", 4280);
        addNewEmployee("Alex White", 2362);
        addNewEmployee("Pavel Varna", 2886);
        addNewEmployee("Andrey Astapov", 5021);
        addNewEmployee("Fedor Barahoev", 2308);
    }

    @Override
    // метод для добавления сотрудника
    public Employee addNewEmployee(String fullName, int passportNumber)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {

        Employee employee = new Employee(fullName, passportNumber);

        // проверка на наличие сотрудника перед добавлением
        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException("Ошибка! Сотрудник уже добавлен в список!");
        }

        // проверка на заполненность списка
        if (employees.size() == MAX_SIZE){
            throw new EmployeeStorageIsFullException("Ошибка! Список заполнен!");
        }

        // добавляем сотрудника, увеличиваем счетчик сотрудников
        employees.put(employee.getFullName(), employee);

        return employee;
    }

    @Override
    // метод для удаления сотрудника
    public Employee removeEmployee(String fullName, int passportNumber)
            throws EmployeeNotFoundException {

        Employee employee = new Employee(fullName, passportNumber);

        // проверка на наличие сотрудника перед удалением
        if (!employees.containsKey(employee.getFullName())){
            throw new EmployeeNotFoundException("Ошибка! Сотрудник не найден!");
        }

        // удаляем сотрудника, уменьшаем счетчик
        employees.remove(employee.getFullName(), employee);

        return employee;
    }

    @Override
    // метод для поиска сотрудника
    public Employee findEmployee(String fullName, int passportNumber)
            throws EmployeeNotFoundException {

        Employee employee = new Employee(fullName, passportNumber);

        if (employees.containsKey(employee.getFullName())){
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Ошибка! Сотрудник не найден!");
    }

    @Override
    public Collection<Employee> findAll(){
        return Collections.unmodifiableCollection(employees.values());
    }
}