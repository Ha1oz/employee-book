package net.haloz.corporation.service.impl;

import net.haloz.corporation.entities.Department;
import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.repo.EmployeeBook;
import net.haloz.corporation.service.api.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeBook employeeBook;
    public DepartmentServiceImpl(EmployeeBook employeeBook) {
        this.employeeBook = employeeBook;
    }
    @Override
    public List<Employee> getAllEmployees(Department department) {
        return employeeBook.getAllEmployees(department);
    }
    @Override
    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeBook.getAllEmployees();
    }
    @Override
    public Double getMinSalary(Department department) {
        return employeeBook.getEmployeeWithMinSalary(department).getSalary();
    }
    @Override
    public Double getMaxSalary(Department department) {
        return employeeBook.getEmployeeWithMaxSalary(department).getSalary();
    }
    @Override
    public Double getEmployeesMonthlyPayment(Department department) {
        return employeeBook.getAllEmployees(department).stream().mapToDouble(Employee::getSalary).sum();
    }
    @Override
    public Double getAverageSalary(Department department) {
        List<Employee> employees = employeeBook.getAllEmployees(department);
        if (employees.isEmpty()) {
            return 0.0;
        }
        return getEmployeesMonthlyPayment(department) / employees.size();
    }
    @Override
    public void employeesSalaryIndexation(Department department, Double percentIndexation) {
        employeeBook.getAllEmployees(department).forEach(e -> e.salaryIndexation(percentIndexation));
    }
    @Override
    public List<Employee> findEmployeeWithSalaryLessThan(Department department, double value) {
        return employeeBook.getAllEmployees(department).stream().filter(v -> v.getSalary() < value).toList();
    }
    @Override
    public List<Employee> findEmployeeWithSalaryHigherThan(Department department, double value) {
        return employeeBook.getAllEmployees(department).stream().filter(v -> v.getSalary() > value).toList();
    }
}
