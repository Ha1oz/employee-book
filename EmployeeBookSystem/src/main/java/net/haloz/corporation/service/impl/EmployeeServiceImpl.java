package net.haloz.corporation.service.impl;

import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.repo.EmployeeBook;
import net.haloz.corporation.service.api.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeBook employeeBook;
    public EmployeeServiceImpl(EmployeeBook employeeBook) {
        this.employeeBook = employeeBook;
    }
    @Override
    public void addEmployee(Employee employee){
        employeeBook.addEmployee(employee);
    }
    @Override
    public Employee getEmployee(String firstName, String lastName){
        return employeeBook.getEmployee(firstName, lastName);
    }
    @Override
    public void deleteEmployee(String firstName, String lastName) {
        employeeBook.deleteEmployee(firstName, lastName);
    }
    @Override
    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeBook.getAllEmployees();
    }
}
