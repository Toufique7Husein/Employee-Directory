package practice.jpaandthymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practice.jpaandthymleaf.entity.Employee;
import practice.jpaandthymleaf.service.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/list")
    public String listEmployee(Model model) {
        List<Employee> employees = employeeService.findByAll();
        model.addAttribute("employees", employees);
        System.out.println(model.toString());
        return "list-employee";
    }

    @GetMapping("/showform")
    public String form(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        System.out.println("hiii");
        return "employee-regi-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model) {
        //get the emp id
        Employee employee = employeeService.findById(id);

        //set employee on the model to prepopultae th from
        model.addAttribute("employee", employee);
        //sent over our from
        return "employee-regi-form";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam("employeeId") int id, Model  model) {
         employeeService.deleteById(id);
         return "redirect:/list";
    }
}
