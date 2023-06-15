package net.haloz.corporation.controller;

import net.haloz.corporation.entities.Department;
import net.haloz.corporation.exceptions.*;
import net.haloz.corporation.service.EmployeeBookService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeBookController {
    private final EmployeeBookService employeeBookService;

    public EmployeeBookController(EmployeeBookService employeeBookService) {
        this.employeeBookService = employeeBookService;
    }

    @GetMapping("/add")
    @NonNull
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            employeeBookService.addEmployee(lastName, firstName, Department.randomDepartment(), Department.randomSalary());
        } catch (ArrayIsFullException e) {
            e.printStackTrace();
            return "Cannot add employee, the allowed number of employees is exceeded. Please try again later.";
        } catch (EmployeeInvalidDataException e) {
            e.printStackTrace();
            return "Cannot add employee, invalid input data. Please correct your request.";
        } catch (EmployeeAlreadyAddedException e) {
            e.printStackTrace();
            return "Cannot add employee, employee is already exist.";
        }
        return String.format("New employee %s %s is added", firstName, lastName);
    }
    @GetMapping("/find")
    @NonNull
    public String findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {

        try {
             return employeeBookService.getEmployee(firstName, lastName).toString();
        } catch (EmployeeBaseEmptyException e) {
            e.printStackTrace();
            return "Employee base is empty.";
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            return "Cannot find employee in base. Pls correct your request.";
        }
    }
    @GetMapping("/remove")
    @NonNull
    public String removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            employeeBookService.deleteEmployee(firstName,lastName);
            return "Employee was removed from base.";
        } catch (EmployeeBaseEmptyException e) {
            e.printStackTrace();
            return "Employee base is empty.";
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            return "Cannot find employee in base. Please correct your request.";
        }
    }
    @GetMapping("/all")
    @NonNull
    public String findAllEmployees() {
        try {
            return employeeBookService.getAllEmployees().toString();
        } catch (EmployeeBaseEmptyException e) {
            e.printStackTrace();
            return "Employee base is empty.";
        }
    }
}
