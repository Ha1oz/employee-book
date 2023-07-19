package net.haloz.corporation.repo;

import net.haloz.corporation.entities.Department;
import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.exceptions.EmployeeAlreadyAddedException;
import net.haloz.corporation.exceptions.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeBook {
    private final Map<Integer, List<Employee>> employeeBook = new HashMap<>();
    private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeBook.class);

    public EmployeeBook() {
        Arrays.stream(Department.values()).forEach(d -> employeeBook.put(d.getId(), new ArrayList<>()));
        LOGGER.info("Base of employees is created.");
    }

    public void addEmployee(Employee employee) {
        if(employeeBook.values().stream().anyMatch(employees -> employees.contains(employee))){
            throw new EmployeeAlreadyAddedException("Employee is already added in base.");
        }
        employeeBook.get(employee.getDepartment().getId()).add(employee);
        LOGGER.info("Employee is added.");
    }
    public Employee getEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName, Department.DEPARTMENT_1, 0.0);

        for (List<Employee> s : employeeBook.values()) {
            Employee res = s.stream()
                    .filter(e -> e.equals(employee))
                    .findFirst()
                    .orElse(null);
            if (res != null) {
                LOGGER.info("Employee is found.");
                return res;
            }
        }
        throw new EmployeeNotFoundException();
    }
    public void deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName, Department.DEPARTMENT_1, 0.0);
        employeeBook.values().forEach(s -> {
            if(s.remove(employee)){
                LOGGER.info("Employee was removed");
            }
        });
    }
    public Map<Integer, List<Employee>> getAllEmployees() {
        return new HashMap<>(employeeBook);
    }
    public List<Employee> getAllEmployees(Department department) {
        return employeeBook.get(department.getId());
    }
    public Employee getEmployeeWithMinSalary(Department department) {
        return employeeBook.get(department.getId()).stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }
    public Employee getEmployeeWithMaxSalary(Department department) {
        return employeeBook.get(department.getId()).stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }
}
