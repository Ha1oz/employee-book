package net.haloz.corporation.service.impl;

import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.repo.EmployeeBook;
import net.haloz.corporation.service.api.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static net.haloz.corporation.entities.Department.DEPARTMENT_1;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    private Employee testEmployee;
    private EmployeeService employeeService;
    @Mock
    private EmployeeBook employeeBookMock;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl(employeeBookMock);
        testEmployee = new Employee("Oleg", "Barkalov", DEPARTMENT_1, 200.0);
    }
    @Test
    void addEmployee() {
        employeeService.addEmployee(testEmployee);
        Mockito.verify(employeeBookMock, Mockito.times(1)).addEmployee(Mockito.any());
    }

    @Test
    void getEmployee() {
        Mockito.doReturn(testEmployee).when(employeeBookMock).getEmployee(Mockito.anyString(), Mockito.anyString());
        Assertions.assertEquals(testEmployee, employeeService.getEmployee(testEmployee.getFirstName(), testEmployee.getLastName()));
    }

    @Test
    void deleteEmployee() {
        employeeService.deleteEmployee(testEmployee.getFirstName(),testEmployee.getLastName());
        Mockito.verify(employeeBookMock, Mockito.times(1)).deleteEmployee(Mockito.anyString(), Mockito.anyString());
    }

    @Test
    void getAllEmployees() {
        Map<Integer, String> expected = new HashMap<>();
        expected.put(testEmployee.getDepartment().getId(), testEmployee.getFirstName());

        Mockito.doReturn(expected).when(employeeBookMock).getAllEmployees();
        Assertions.assertEquals(expected, employeeService.getAllEmployees());
    }
}