package net.haloz.corporation.controller;

import net.haloz.corporation.entities.Department;
import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.service.api.EmployeeService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    @NonNull
    public void addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName, Department.randomDepartment(), Department.randomSalary());
        employeeService.addEmployee(employee);
    }
    @GetMapping("/find")
    @NonNull
    public Employee findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.getEmployee(firstName, lastName);
    }
    @GetMapping("/remove")
    @NonNull
    public void removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeeService.deleteEmployee(firstName,lastName);
    }
    @GetMapping("/all")
    @NonNull
    public Map<Integer, List<Employee>> findAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
