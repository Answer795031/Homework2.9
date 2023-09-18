package pro.sky.homework_2_9;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentServiceC departmentService;

    public DepartmentController(DepartmentServiceC departmentService) {
        this.departmentService = departmentService;
    }

    @ExceptionHandler
    public String handleException(Exception e) {
        return e.getMessage();
    }

    @GetMapping(path = "/max-salary")  // /departments/max-salary?departmentId=5
    public Employee findMaxSalary(@RequestParam("departmentId") int departmentId)
            throws EmployeeNotFoundException {
        return departmentService.findMaxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")  // /departments/min-salary?departmentId=5
    public Employee findMinSalary(@RequestParam("departmentId") int departmentId)
            throws EmployeeNotFoundException {
        return departmentService.findMinSalary(departmentId);
    }

    @GetMapping(path = "/all", params = {"departmentId"})  // /departments/all-by-department?departmentId=5
    public Employee findAllByDepartment(@RequestParam("departmentId") int departmentId)
            throws EmployeeNotFoundException {
        return departmentService.findAllByDepartment(departmentId);
    }

    @GetMapping(path = "/all")  // /departments/all
    public Map<Integer, List<Employee>> findAll() throws EmployeeNotFoundException {
        return departmentService.findAll();
    }
}
