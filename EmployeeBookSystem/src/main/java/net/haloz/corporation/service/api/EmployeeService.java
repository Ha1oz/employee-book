package net.haloz.corporation.service.api;

import net.haloz.corporation.entities.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    void addEmployee(Employee employee);

    Employee getEmployee(String firstName, String lastName);

    void deleteEmployee(String firstName, String lastName);

    Map<Integer, List<Employee>> getAllEmployees();
}
