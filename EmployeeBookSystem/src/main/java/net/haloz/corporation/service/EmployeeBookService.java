package net.haloz.corporation.service;

import net.haloz.corporation.entities.Department;
import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.exceptions.ArrayIsFullException;
import net.haloz.corporation.exceptions.EmployeeAlreadyAddedException;
import net.haloz.corporation.exceptions.EmployeeBaseEmptyException;
import net.haloz.corporation.exceptions.EmployeeNotFoundException;

import java.util.*;

public class EmployeeBookService {
    private static final Integer MAX_EMPLOYEES_NUMBER = 2;
    private final HashMap<Integer, Employee> employeeHashMap = new HashMap<>();

    public EmployeeBookService(){
        System.out.println("Base of employees is created.");
    }
    public void addEmployee(String surname, String name, Department department, Double salary){
        if (employeeHashMap.size() >= MAX_EMPLOYEES_NUMBER) {
            throw new ArrayIsFullException();
        }
        Employee employee = new Employee(surname, name, department, salary);
        Integer employeeId = employee.hashCode();
        if (employeeHashMap.containsKey(employeeId)) {
            throw new EmployeeAlreadyAddedException("The employee with id " + employeeId + " is already added.");
        }
        employeeHashMap.put(employeeId, employee);
    }
    public Employee getEmployee(String firstName, String lastName){
        if (employeeHashMap.isEmpty()) {
            throw new EmployeeBaseEmptyException();
        }
        Integer employeeId = Objects.hash(firstName, lastName);
        if (!employeeHashMap.containsKey(employeeId)) {
            throw new EmployeeNotFoundException("The employee with id " + employeeId + " not found");
        }
        return employeeHashMap.get(employeeId);
    }
    public void deleteEmployee(String firstName, String lastName) {
        if (employeeHashMap.isEmpty()) {
            throw new EmployeeBaseEmptyException();
        }
        Integer employeeId = Objects.hash(firstName, lastName);
        if (!employeeHashMap.containsKey(employeeId)) {
            throw new EmployeeNotFoundException("The employee with id " + employeeId + " not found");
        }

        employeeHashMap.remove(employeeId);
    }
    public HashMap<Integer, Employee> getAllEmployees() {
        if (employeeHashMap.isEmpty()) {
            throw new EmployeeBaseEmptyException();
        }
        return employeeHashMap;
    }
    public List<Employee> getAllEmployees(Department department) {
        if (employeeHashMap.isEmpty()) {
            throw new EmployeeBaseEmptyException();
        }
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
                    buff.append(String.format("\t - %s %s\n", employee.getLastName(), employee.getFirstName()));
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

    public void changeEmployeeSalary(String firstName, String lastName, Double newSalary) {
        Integer employeeId = Objects.hash(firstName, lastName);
        if (!employeeHashMap.containsKey(employeeId)) {
            throw new EmployeeNotFoundException("The employee with id " + employeeId + " not found");
        }
        employeeHashMap.get(employeeId).setSalary(newSalary);
    }
    public void changeEmployeeDepartment(String firstName, String lastName, Department department) {
        Integer employeeId = Objects.hash(firstName, lastName);
        if (!employeeHashMap.containsKey(employeeId)) {
            throw new EmployeeNotFoundException("The employee with id " + employeeId + " not found");
        }
        employeeHashMap.get(employeeId).setDepartment(department);
    }

}
