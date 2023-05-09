package net.haloz.corporation.entities;

import lombok.Getter;
import lombok.Setter;
import net.haloz.corporation.exceptions.EmployeeException;
import net.haloz.corporation.exceptions.HashMapEmployeeException;

import java.util.Objects;

@Getter
public class Employee {
    private static int id;
    private final int employeeId;
    private final String surname, name, fathersName;
    private Department department;
    private double salary = 0.0d;

    public  Employee(String newSurname, String newName, String newFathersName, Department newDepartment, Double newSalary) throws EmployeeException {
        if (newSurname.isEmpty() || newName.isEmpty() || newFathersName.isEmpty() || newDepartment == null || newSalary < 0d) {
            throw new EmployeeException("Invalid employee data");
        }
        employeeId = id;
        surname = newSurname;
        name = newName;
        fathersName = newFathersName;
        department = newDepartment;
        salary = newSalary;
        id++;
    }

    public void setSalary(double salary) throws EmployeeException {
        if (salary < 0d) {
            throw new EmployeeException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    public void setDepartment(Department department) throws EmployeeException {
        if (department == null) {
            throw new EmployeeException("Department cannot be null");
        }
        this.department = department;
    }

    public void salaryIndexation(Double percent) {
        salary += (salary / 100.0d * percent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(surname, employee.surname) && Objects.equals(name, employee.name) && Objects.equals(fathersName, employee.fathersName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, fathersName);
    }

    @Override
    public String toString(){
        return String.format("[Id: %d; Surname: %s; Name: %s; FathersName: %s; Department: %s; Salary: %f]",
                employeeId, surname, name, fathersName, department.name(), salary);
    }



}
