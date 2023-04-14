package net.haloz.corporation.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Employee {
    private static int id;
    private final int employeeId;
    private final String surname, name, fathersName;
    private @Getter @Setter String department = "";
    private @Getter @Setter double salary = 0.0d;

    public Employee(String newSurname, String newName, String newFathersName) {
        employeeId = id;
        surname = newSurname;
        name = newName;
        fathersName = newFathersName;
        id++;
    }
    public  Employee(String newSurname, String newName, String newFathersName, String newDepartment, Double newSalary) {
        this(newSurname, newName, newFathersName);
        department = newDepartment;
        salary = newSalary;
    }

    @Override
    public String toString(){
        return String.format("[Id: %d; Surname: %s; Name: %s; FathersName: %s; Department: %s; Salary: %f]",
                employeeId, surname, name, fathersName, department, salary);
    }


}
