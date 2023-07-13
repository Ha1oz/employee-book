package net.haloz.corporation.service;

import net.haloz.corporation.entities.Department;
import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.repo.EmployeeBook;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {
    private final EmployeeBook employeeBook;
    public DepartmentService(EmployeeBook employeeBook) {
        this.employeeBook = employeeBook;
    }
    public List<Employee> getAllEmployees(Department department) {
        return employeeBook.getAllEmployees(department);
    }
    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeBook.getAllEmployees();
    }
    public Double getMinSalary(Department department) {
        return employeeBook.getEmployeeWithMinSalary(department).getSalary();
    }
    public Double getMaxSalary(Department department) {
        return employeeBook.getEmployeeWithMaxSalary(department).getSalary();
    }
    public Double getEmployeesMonthlyPayment(Department department) {
        double sum = 0.0;
        for (Employee e : employeeBook.getAllEmployees(department)) {
            sum += e.getSalary();
        }
        return sum;
    }
    public Double getAverageSalary(Department department) {
        List<Employee> employees = employeeBook.getAllEmployees(department);
        if (employees.isEmpty()) {
            return 0.0;
        }
        return getEmployeesMonthlyPayment(department) / employees.size();
    }
    public void employeesSalaryIndexation(Department department, Double percentIndexation) {
        employeeBook.getAllEmployees(department).forEach(e -> e.salaryIndexation(percentIndexation));
    }
    public List<Employee> findEmployeeWithSalaryLessThan(Department department, double value) {
        return employeeBook.getAllEmployees(department).stream().filter(v -> v.getSalary() < value).toList();
    }
    public List<Employee> findEmployeeWithSalaryHigherThan(Department department, double value) {
        return employeeBook.getAllEmployees(department).stream().filter(v -> v.getSalary() > value).toList();
    }
}
