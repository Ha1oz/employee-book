package net.haloz.corporation.service;

import net.haloz.corporation.entities.Department;
import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.repo.EmployeeBook;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class EmployeeService {
    private final EmployeeBook employeeBook;
    public EmployeeService(EmployeeBook employeeBook) {
        this.employeeBook = employeeBook;
    }

    public void addEmployee(String firstName, String lastName, Department department, Double salary){
        employeeBook.addEmployee(firstName, lastName, department, salary);
    }
    public Employee getEmployee(String firstName, String lastName){
        return employeeBook.getEmployee(firstName, lastName);
    }
    public void deleteEmployee(String firstName, String lastName) {
        employeeBook.deleteEmployee(firstName, lastName);
    }
    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeBook.getAllEmployees();
    }
}
