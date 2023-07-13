package net.haloz.corporation;

import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.repo.EmployeeBook;
import net.haloz.corporation.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static net.haloz.corporation.entities.Department.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeBook employeeBookMock;
    @InjectMocks
    private EmployeeService employeeService;
    @Test
    public void addDeleteGetMethod() {
        Mockito.doNothing().when(employeeBookMock).addEmployee("Oleg", "Barkalov", DEPARTMENT_1, 200.0);
        Mockito.doNothing().when(employeeBookMock).deleteEmployee("Oleg", "Barkalov");
        Mockito.when(employeeBookMock.getEmployee("Oleg", "Barkalov")).thenReturn(new Employee("Oleg", "Barkalov", DEPARTMENT_1, 200.0));

        employeeService.addEmployee("Oleg", "Barkalov", DEPARTMENT_1, 200.0);
        employeeService.deleteEmployee("Oleg", "Barkalov");
        Assertions.assertEquals(new Employee("Oleg", "Barkalov", DEPARTMENT_1, 200.0),employeeService.getEmployee("Oleg", "Barkalov"));

        Mockito.verify(employeeBookMock,Mockito.times(1)).addEmployee("Oleg", "Barkalov", DEPARTMENT_1, 200.0);
        Mockito.verify(employeeBookMock,Mockito.times(1)).deleteEmployee("Oleg", "Barkalov");
        Mockito.verify(employeeBookMock,Mockito.times(1)).getEmployee("Oleg", "Barkalov");
    }
}
