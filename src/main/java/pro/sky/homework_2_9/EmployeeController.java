package pro.sky.homework_2_9;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @ExceptionHandler
    public String handleException(RuntimeException e){
        return e.getMessage();
    }

    private final EmployeeServiceImpl employeeService;

    // инжектим EmployeeService в EmployeeController
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String employees(){
        return employeeService.employees();
    }

    // добавление сотрудника
    @GetMapping(path = "/add")   // /employee/add?fullName=Ivan_Ivanov&passportNumber=3498&salary=10000&departmentId=4
    public Employee addNewEmployee(@RequestParam("fullName") String fullName,
                                   @RequestParam("passportNumber") int passportNumber,
                                   @RequestParam("salary") int salary,
                                   @RequestParam("departmentId") int departmentId)
            throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        return employeeService.addNewEmployee(fullName, passportNumber, salary, departmentId);
    }

    // удаление сотрудника
    @GetMapping(path = "/remove")    // /employee/remove?fullName=Ivan_Ivanov&passportNumber=3498&salary=10000&departmentId=4
    public Employee removeEmployee(@RequestParam("fullName") String fullName,
                                   @RequestParam("passportNumber") int passportNumber,
                                   @RequestParam("salary") int salary,
                                   @RequestParam("departmentId") int departmentId)
            throws EmployeeNotFoundException {
        return employeeService.removeEmployee(fullName, passportNumber, salary, departmentId);
    }

    // поиск сотрудника
    @GetMapping(path = "/find")  // /employee/find?fullName=Ivan_Ivanov&passportNumber=3498&salary=10000&departmentId=4
    public Employee findEmployee(@RequestParam("fullName") String fullName,
                                 @RequestParam("passportNumber") int passportNumber,
                                 @RequestParam("salary") int salary,
                                 @RequestParam("departmentId") int departmentId)
            throws EmployeeNotFoundException {
        return employeeService.findEmployee(fullName, passportNumber, salary, departmentId);
    }
}