package net.haloz.corporation.controller;

import net.haloz.corporation.entities.Department;
import net.haloz.corporation.exceptions.EmployeeAlreadyAddedException;
import net.haloz.corporation.exceptions.EmployeeBaseEmptyException;
import net.haloz.corporation.exceptions.EmployeeInvalidDataException;
import net.haloz.corporation.exceptions.EmployeeNotFoundException;
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
            employeeBookService.addEmployee(lastName, firstName, Department.DEPARTMENT_1, 0.0);
        } catch (EmployeeInvalidDataException e) {
            e.printStackTrace();
            return "Cannot add employee, invalid input data. Pls correct your request.";
        } catch (EmployeeAlreadyAddedException e) {
            e.printStackTrace();
            return "Cannot add employee, employee's already exist.";
        }
        return String.format("New employee %s %s is added", lastName, firstName);
    }
    @GetMapping("/find")
    @NonNull
    public String findEmployee(@RequestParam("id") Integer employeeId) {

        try {
             return employeeBookService.getEmployee(employeeId).toString();
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
    public String removeEmployee(@RequestParam("id") Integer employeeId) {
        try {
            employeeBookService.deleteEmployee(employeeId);
            return "Employee was deleted from base.";
        } catch (EmployeeBaseEmptyException e) {
            e.printStackTrace();
            return "Employee base is empty.";
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            return "Cannot find employee in base. Pls correct your request.";
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
