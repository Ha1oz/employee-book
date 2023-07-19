package net.haloz.corporation.service.api;

import net.haloz.corporation.entities.Department;
import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.repo.EmployeeBook;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Employee> getAllEmployees(Department department);

    Map<Integer, List<Employee>> getAllEmployees();

    Double getMinSalary(Department department);

    Double getMaxSalary(Department department);

    Double getEmployeesMonthlyPayment(Department department);

    Double getAverageSalary(Department department);

    void employeesSalaryIndexation(Department department, Double percentIndexation);

    List<Employee> findEmployeeWithSalaryLessThan(Department department, double value);

    List<Employee> findEmployeeWithSalaryHigherThan(Department department, double value);
}
