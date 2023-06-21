package net.haloz.corporation.controller;

import net.haloz.corporation.entities.Department;
import net.haloz.corporation.service.EmployeeBookService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final EmployeeBookService employeeBookService;

    public DepartmentController(EmployeeBookService employeeBookService) {
        this.employeeBookService = employeeBookService;
    }
    @GetMapping("/max-salary")
    @NonNull
    public String outMaxSalaryEmployee(Integer departmentId) {
        try {
            return employeeBookService.employeeWithMaxSalary(Department.getDepartment(departmentId)).toString();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return "Cannot find employees with this params. Please correct your request.";
        }
    }
    @GetMapping("/min-salary")
    @NonNull
    public String outMinSalaryEmployee(Integer departmentId) {
        try {
            return employeeBookService.employeeWithMinSalary(Department.getDepartment(departmentId)).toString();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return "Cannot find employees with this params. Please correct your request.";
        }
    }
    @RequestMapping(value = "/all", params = "departmentId")
    @NonNull
    public String outAllEmployee(Integer departmentId) {
        try {
            return employeeBookService.getAllEmployees(Department.getDepartment(departmentId)).toString();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return "Cannot find employees with this params. Please correct your request.";
        }
    }
    @RequestMapping(value = "/all")
    public String outAllEmployee() {
        return employeeBookService.fullNamesEmployees();
    }

}
