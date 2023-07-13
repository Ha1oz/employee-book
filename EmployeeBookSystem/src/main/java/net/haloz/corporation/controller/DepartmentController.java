package net.haloz.corporation.controller;

import net.haloz.corporation.entities.Department;
import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.service.DepartmentService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    @NonNull
    public List<Employee> outAllEmployees(@PathVariable Integer id) {
        return departmentService.getAllEmployees(Department.getDepartment(id));
    }
    @GetMapping("/{id}/salary/max")
    @NonNull
    public Double outMaxSalaryEmployee(@PathVariable Integer id) {
        return departmentService.getMaxSalary(Department.getDepartment(id));
    }
    @GetMapping("/{id}/salary/min")
    @NonNull
    public Double outMinSalaryEmployee(@PathVariable Integer id) {
        return departmentService.getMinSalary(Department.getDepartment(id));
    }
    @GetMapping("/{id}/salary/sum")
    @NonNull
    public Double outMonthlyPaymentSalary(@PathVariable Integer id) {
        return departmentService.getEmployeesMonthlyPayment(Department.getDepartment(id));
    }
    @GetMapping("/employees")
    @NonNull
    public Map<Integer, List<Employee>> outAllDepartments() {
        return departmentService.getAllEmployees();
    }
}
