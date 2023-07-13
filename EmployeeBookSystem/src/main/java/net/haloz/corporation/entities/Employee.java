package net.haloz.corporation.entities;

import lombok.Getter;
import lombok.NonNull;
import net.haloz.corporation.exceptions.EmployeeInvalidDataException;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
@Getter
public class Employee {
    private final String firstName, lastName;
    private Department department;
    private double salary = 0.0d;
    @NonNull
    public  Employee(String firstName, String lastName, Department department, Double salary) {
        if (!StringUtils.isAlpha(lastName) || !StringUtils.isAlpha(firstName) || salary < 0d) {
            throw new EmployeeInvalidDataException(String.format("firstName: %s; lastName: %s; Department: %s; salary: %f",
                    firstName,
                    lastName,
                    department,
                    salary));
        }
        this.firstName = StringUtils.capitalize(firstName);
        this.lastName = StringUtils.capitalize(lastName);
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
