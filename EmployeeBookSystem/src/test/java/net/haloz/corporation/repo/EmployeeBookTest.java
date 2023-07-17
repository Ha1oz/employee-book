package net.haloz.corporation.repo;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import net.haloz.corporation.entities.Department;
import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.exceptions.EmployeeAlreadyAddedException;
import net.haloz.corporation.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeBookTest {

    private EmployeeBook employeeBook;
    private Employee testEmployee, testEmployee2;
    @BeforeEach
    void setUp() {
        employeeBook = new EmployeeBook();
        testEmployee = new Employee("Alex", "Merser", Department.DEPARTMENT_1, 100.0);
        testEmployee2 = new Employee("Vito", "Scaletta", Department.DEPARTMENT_1, 200.0);

    }

    @Test
    void addAndGetEmployee() {
        employeeBook.addEmployee(testEmployee);
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> employeeBook.addEmployee(testEmployee));
        Assertions.assertEquals(testEmployee, employeeBook.getEmployee(testEmployee.getFirstName(), testEmployee.getLastName()));
    }

    @Test
    void deleteEmployee() {
        addAndGetEmployee();
        employeeBook.deleteEmployee(testEmployee.getFirstName(), testEmployee.getLastName());
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeBook.getEmployee(testEmployee.getFirstName(), testEmployee.getLastName()));
    }

    @Test
    void getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(testEmployee);
        employees.add(testEmployee2);

        Map<Integer, List<Employee>> expected = employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment().getId()));
        Arrays.stream(Department.values()).forEach(d -> {
            if (!expected.containsKey(d.getId())) {
                expected.put(d.getId(), new ArrayList<>());
            }
        });

        employeeBook.addEmployee(testEmployee);
        employeeBook.addEmployee(testEmployee2);

        Assertions.assertEquals(expected, employeeBook.getAllEmployees());
    }

    @Test
    void getEmployeeWithMinSalary() {
        employeeBook.addEmployee(testEmployee);
        employeeBook.addEmployee(testEmployee2);
        Assertions.assertEquals(testEmployee.getSalary() < testEmployee2.getSalary() ? testEmployee : testEmployee2, employeeBook.getEmployeeWithMinSalary(testEmployee.getDepartment()));
    }

    @Test
    void getEmployeeWithMaxSalary() {
        employeeBook.addEmployee(testEmployee);
        employeeBook.addEmployee(testEmployee2);
        Assertions.assertEquals(testEmployee.getSalary() > testEmployee2.getSalary() ? testEmployee : testEmployee2, employeeBook.getEmployeeWithMaxSalary(testEmployee.getDepartment()));
    }
}