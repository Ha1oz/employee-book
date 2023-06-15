package net.haloz.corporation.entities;

import lombok.Getter;
import lombok.NonNull;
import net.haloz.corporation.exceptions.EmployeeInvalidDataException;

import java.util.Objects;
@Getter
public class Employee {
    private final String lastName, firstName;
    private Department department;
    private double salary = 0.0d;
    @NonNull
    public  Employee(String lastName, String firstName, Department department, Double salary) {
        if (lastName.isEmpty() || firstName.isEmpty() || salary < 0d) {
            throw new EmployeeInvalidDataException(String.format("Surname: %s; name: %s; Department: %s; salary: %f",
                    lastName,
                    firstName,
                    department,
                    salary));
        }
        this.lastName = lastName;
        this.firstName = firstName;
        this.department = department;
        this.salary = salary;
    }
    public void setSalary(double salary) {
        if (salary < 0d) {
            throw new EmployeeInvalidDataException("Salary cannot be negative: " + salary);
        }
        this.salary = salary;
    }
    @NonNull
    public void setDepartment(Department department) {
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
        return Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
    @Override
    public String toString(){
        return String.format("{\"firstName\": \"%s\"; \"lastName\": \"%s\"; \"department\": \"%s\"; \"salary\": %f}",
                firstName, lastName, department.name(), salary);
    }



}
