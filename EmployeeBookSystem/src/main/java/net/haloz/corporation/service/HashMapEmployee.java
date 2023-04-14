package net.haloz.corporation.service;

import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.exceptions.HashMapEmployeeException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapEmployee {
    private final HashMap<Integer, Employee> employeeHashMap = new HashMap<>();

    public HashMapEmployee(){
        System.out.println("Base of employees is created.");
    }

    public void addEmployee(Employee employee) throws HashMapEmployeeException {
        int id = employee.hashCode();

        if (employeeHashMap.containsKey(id)) {
            throw new HashMapEmployeeException("Employee with id " + id + " is already in the base");
        }

        employeeHashMap.put(id, employee);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeHashMap.values());
    }

    public Double monthlyPaymentAmount() {
        double sum = 0.0d;

        if (employeeHashMap.isEmpty()) {
            return 0d;
        }

        for (Employee employee : employeeHashMap.values()) {
            sum += employee.getSalary();
        }

        return sum;
    }


}
