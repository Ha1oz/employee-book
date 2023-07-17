package net.haloz.corporation.service.impl;

import net.haloz.corporation.entities.Department;
import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.repo.EmployeeBook;
import net.haloz.corporation.service.api.DepartmentService;
import net.haloz.corporation.service.api.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.haloz.corporation.entities.Department.DEPARTMENT_1;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    private Employee testEmployee, testEmployee2;
    private DepartmentService departmentService;
    @Mock
    private EmployeeBook employeeBookMock;

    @BeforeEach
    void setUp() {
        departmentService = new DepartmentServiceImpl(employeeBookMock);
        testEmployee = new Employee("Oleg", "Barkalov", DEPARTMENT_1, 200.0);
        testEmployee2 = new Employee("Alex", "Merser", Department.DEPARTMENT_1, 100.0);
    }

    @Test
    void getAllEmployees() {
        Map<Integer, String> expected = new HashMap<>();
        expected.put(testEmployee.getDepartment().getId(), testEmployee.getFirstName());

        Mockito.doReturn(expected).when(employeeBookMock).getAllEmployees();
        Assertions.assertEquals(expected, departmentService.getAllEmployees());
    }

    @Test
    void getMinSalary() {
        Mockito.doReturn(testEmployee).when(employeeBookMock).getEmployeeWithMinSalary(testEmployee.getDepartment());
        Assertions.assertEquals(testEmployee.getSalary(), departmentService.getMinSalary(testEmployee.getDepartment()));
    }

    @Test
    void getMaxSalary() {
        Mockito.doReturn(testEmployee).when(employeeBookMock).getEmployeeWithMaxSalary(testEmployee.getDepartment());
        Assertions.assertEquals(testEmployee.getSalary(), departmentService.getMaxSalary(testEmployee.getDepartment()));
    }

    @Test
    void getEmployeesMonthlyPayment() {
        List<Employee> expected = new ArrayList<>();
        expected.add(testEmployee);
        expected.add(testEmployee2);

        Mockito.doReturn(expected).when(employeeBookMock).getAllEmployees(testEmployee.getDepartment());
        Assertions.assertEquals(expected.stream().mapToDouble(Employee::getSalary).sum(), departmentService.getEmployeesMonthlyPayment(testEmployee.getDepartment()));
    }

    @Test
    void getAverageSalary() {
        List<Employee> expected = new ArrayList<>();
        expected.add(testEmployee);
        expected.add(testEmployee2);

        Mockito.doReturn(expected).when(employeeBookMock).getAllEmployees(testEmployee.getDepartment());
        Assertions.assertEquals(expected.stream().mapToDouble(Employee::getSalary).sum() / expected.size(), departmentService.getAverageSalary(testEmployee.getDepartment()));
    }

    @Test
    void employeesSalaryIndexation() {
        departmentService.employeesSalaryIndexation(DEPARTMENT_1, 10.0);
        Mockito.verify(employeeBookMock, Mockito.times(1)).getAllEmployees(Mockito.any());
    }

    @Test
    void findEmployeeWithSalaryLessThan() {
        List<Employee> expected = new ArrayList<>();
        expected.add(testEmployee);
        expected.add(testEmployee2);
        double x = 50.0;

        Mockito.doReturn(expected).when(employeeBookMock).getAllEmployees(testEmployee.getDepartment());
        Assertions.assertEquals(new ArrayList<>(), departmentService.findEmployeeWithSalaryLessThan(testEmployee.getDepartment(), x));
    }

    @Test
    void findEmployeeWithSalaryHigherThan() {
        List<Employee> expected = new ArrayList<>();
        expected.add(testEmployee);
        expected.add(testEmployee2);
        double x = 300.0;

        Mockito.doReturn(expected).when(employeeBookMock).getAllEmployees(testEmployee.getDepartment());
        Assertions.assertEquals(new ArrayList<>(), departmentService.findEmployeeWithSalaryHigherThan(testEmployee.getDepartment(), x));
    }
}