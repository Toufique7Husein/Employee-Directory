package practice.jpaandthymleaf.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.jpaandthymleaf.entity.Employee;
import practice.jpaandthymleaf.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> getEmployee() {
        return employeeService.findByAll();
    }


    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.findById(id);
    }


    @PostMapping("/employees")
    public Employee setEmployee(@RequestBody Employee employee) {
        System.out.println("Hiii");
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }


    @PutMapping("/employees")
    public String edit(@RequestBody Employee employee) {
        employeeService.save(employee);
        return "successful";
    }

    @DeleteMapping("/employees/{id}")
    public String delete(@PathVariable int id) {
        employeeService.deleteById(id);
        return "deleted successfully...";
    }

}
