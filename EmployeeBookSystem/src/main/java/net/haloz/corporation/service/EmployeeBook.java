package net.haloz.corporation.service;

import net.haloz.corporation.entities.Department;
import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.exceptions.EmployeeException;
import net.haloz.corporation.exceptions.HashMapEmployeeException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class EmployeeBook {
    private final HashMap<Integer, Employee> employeeHashMap = new HashMap<>();

    public EmployeeBook(){
        System.out.println("Base of employees is created.");
    }
    public void addEmployee(String surname, String name, String fathersName, Department department, Double salary) throws EmployeeException{
        Employee employee = new Employee(surname, name, fathersName, department, salary);

        employeeHashMap.put(employee.getEmployeeId(), employee);
    }
    public Employee getEmployee(Integer employeeId) throws HashMapEmployeeException {
        if (employeeHashMap.isEmpty()) {
            throw new HashMapEmployeeException("The employee base is empty");
        }

        return employeeHashMap.get(employeeId);
    }
    public void deleteEmployee(Integer employeeId) throws HashMapEmployeeException {
        if (employeeHashMap.isEmpty()) {
            throw new HashMapEmployeeException("The employee base is empty");
        }
        if (!employeeHashMap.containsKey(employeeId)) {
            throw new HashMapEmployeeException("The employee with id " + employeeId + " not found");
        }

        employeeHashMap.remove(employeeId);
    }
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeHashMap.values());
    }
    public List<Employee> getAllEmployees(Department department) {
        return new ArrayList<>(employeeHashMap.values().stream().filter(c -> c.getDepartment().getId() == department.getId()).toList());
    }
    public Double monthlyPaymentAmount() {

        if (employeeHashMap.isEmpty()) {
            return 0d;
        }

        double sum = 0.0d;

        for (Employee employee : employeeHashMap.values()) {
            sum += employee.getSalary();
        }

        return sum;
    }
    public Double monthlyPaymentAmount(Department department) {


        if (employeeHashMap.isEmpty()) {
            return 0d;
        }

        double sum = 0.0d;

        for (Employee employee : employeeHashMap.values()) {
            if (employee.getDepartment().getId() == department.getId()) {
                sum += employee.getSalary();
            }
        }

        return sum;
    }
    public Employee employeeWithMinSalary() {

        if (employeeHashMap.isEmpty()) {
            return null;
        }

        return employeeHashMap.values()
                .stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);

    }
    public Employee employeeWithMinSalary(Department department) {

        if (employeeHashMap.isEmpty()) {
            return null;
        }

        return employeeHashMap.values()
                .stream()
                .filter(c -> c.getDepartment().getId() == department.getId())
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);

    }
    public Employee employeeWithMaxSalary() {

        if (employeeHashMap.isEmpty()) {
            return null;
        }

        return employeeHashMap.values()
                .stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);

    }
    public Employee employeeWithMaxSalary(Department department) {

        if (employeeHashMap.isEmpty()) {
            return null;
        }

        return employeeHashMap.values()
                .stream()
                .filter(c -> c.getDepartment().getId() == department.getId())
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);

    }
    public Double averageSalaries() {
        if (employeeHashMap.isEmpty()) {
            return 0.0d;
        }

        return monthlyPaymentAmount() / employeeHashMap.size();
    }
    public Double averageSalaries(Department department) {
        if (employeeHashMap.isEmpty()) {
            return 0.0d;
        }

        return monthlyPaymentAmount(department) / employeeHashMap.values()
                .stream()
                .filter(c -> c.getDepartment().getId() == department.getId())
                .count();
    }
    public String fullNamesEmployees() {

        if (employeeHashMap.isEmpty()) {
            return "";
        }

        StringBuilder buff = new StringBuilder();

        for (Department department : Department.values()) {
            buff.append("\t").append(department.name()).append(":\n");
            for (Employee employee : employeeHashMap.values()) {
                if (employee.getDepartment().getId() == department.getId()) {
                    buff.append(String.format("\t - %s %s %s\n", employee.getSurname(), employee.getName(), employee.getFathersName()));
                }
            }
        }

        return buff.toString();
    }
    public void employeesSalaryIndexation(Double percentIndexation) {
        for (Employee employee : employeeHashMap.values()) {
            employee.salaryIndexation(percentIndexation);
        }
    }
    public void employeesSalaryIndexation(Department department, Double percentIndexation) {
        for (Employee employee : employeeHashMap.values()) {
            if (employee.getDepartment().getId() == department.getId()) {
                employee.salaryIndexation(percentIndexation);
            }
        }
    }
    public List<Employee> findEmployeeWithSalaryLessThan(Double value) {
        return employeeHashMap.values().stream().filter(v -> v.getSalary() < value).toList();
    }
    public List<Employee> findEmployeeWithSalaryHigherThan(Double value) {
        return employeeHashMap.values().stream().filter(v -> v.getSalary() > value).toList();
    }

    public void changeEmployeeSalary(Integer employeeId, Double newSalary) throws EmployeeException {
        if (employeeHashMap.containsKey(employeeId)) {
            employeeHashMap.get(employeeId).setSalary(newSalary);
        }
    }
    public void changeEmployeeDepartment(Integer employeeId, Department department) throws EmployeeException {
        if (employeeHashMap.containsKey(employeeId)) {
            employeeHashMap.get(employeeId).setDepartment(department);
        }
    }

}
