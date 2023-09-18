package pro.sky.homework_2_9;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @ExceptionHandler
    public String handleException(Exception e){
        return e.getMessage();
    }

    private final EmployeeServiceC employeeService;

    // инжектим EmployeeService в EmployeeController
    public EmployeeController(EmployeeServiceC employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String employees(){
        return employeeService.employees();
    }

    @GetMapping(path = "/add")   // /employee/add?fullName=Ivan_Ivanov&passportNumber=3498
    public Employee addNewEmployee(@RequestParam("fullName") String fullName,
                                   @RequestParam("passportNumber") int passportNumber)
            throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        return employeeService.addNewEmployee(fullName, passportNumber);
    }

    @GetMapping(path = "/remove")    // /employee/remove?fullName=Ivan_Ivanov&passportNumber=3498
    public Employee removeEmployee(@RequestParam("fullName") String fullName,
                                   @RequestParam("passportNumber") int passportNumber)
            throws EmployeeNotFoundException {
        return employeeService.removeEmployee(fullName, passportNumber);
    }

    @GetMapping(path = "/find")  // /employee/find?passportNumber=3498
    public Employee findEmployee(@RequestParam("fullName") String fullName,
                               @RequestParam("passportNumber") int passportNumber)
            throws EmployeeNotFoundException {
        return employeeService.findEmployee(fullName, passportNumber);
    }
}