package net.haloz.corporation;

import net.haloz.corporation.entities.Department;
import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.exceptions.EmployeeException;
import net.haloz.corporation.exceptions.HashMapEmployeeException;
import net.haloz.corporation.service.EmployeeBook;

import java.util.List;

public class Main {
    static EmployeeBook employeeBook = new EmployeeBook();
    public static void main(String[] args) {

        try {
            employeeBook.addEmployee("Oleg", "Barkalov", "Alenovich",
                    Department.DEPARTMENT_1, 23000d);
            employeeBook.addEmployee("Alex", "Mironov", "Ivanovich",
                    Department.DEPARTMENT_2, 200000d);
            employeeBook.addEmployee("Alen", "Barkalov", "Albertovich",
                    Department.DEPARTMENT_3, 400000d);
            employeeBook.addEmployee("Lexa", "Mutno", "Hrenovich",
                    Department.DEPARTMENT_4, 120000d);
            employeeBook.addEmployee("Alexander", "Murno", "Vitaliych",
                    Department.DEPARTMENT_5, 40000d);
            employeeBook.addEmployee("Margaret", "Barkalova", "Sergevna",
                    Department.DEPARTMENT_2, 45000d);
            employeeBook.addEmployee(new Employee("EEEE", "AAAA", "VVVV"),
                    Department.DEPARTMENT_1, 10d);
            outputEmployees();
            employeeBook.deleteEmployee(0);
            employeeBook.changeEmployeeDepartment(1, Department.DEPARTMENT_5);

        } catch (HashMapEmployeeException | EmployeeException e) {
            throw new RuntimeException(e);
        }

        outputFullNameOfEmployees();




    }

    public static void outputEmployees() {
        System.out.println("--------------------------------------------Employees--------------------------------------------");
        for (Employee employee : employeeBook.getAllEmployees()) {
            System.out.println(employee.toString());
        }
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    public static void outputEmployees(Department department) {
        System.out.println("--------------------------------------------Employees--------------------------------------------");
        for (Employee employee : employeeBook.getAllEmployees(department)) {
            System.out.println(employee.toString());
        }
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    public static void outputEmployeesMonthlyPayment() {
        System.out.println("The payout for the month for all employees will be : " + employeeBook.monthlyPaymentAmount());
    }
    public static void outputEmployeesMonthlyPayment(Department department) {
        System.out.println("The payout for the month for employees will be : " + employeeBook.monthlyPaymentAmount(department));
    }

    public static void outputEmployeeWithMinSalary() {
        System.out.println("Minimum salary employee is : " + employeeBook.employeeWithMinSalary());
    }
    public static void outputEmployeeWithMinSalary(Department department) {
        System.out.println("Minimum salary employee is : " + employeeBook.employeeWithMinSalary(department));
    }

    public static void outputEmployeeWithMaxSalary() {
        System.out.println("Maximum salary employee is : " + employeeBook.employeeWithMaxSalary());
    }
    public static void outputEmployeeWithMaxSalary(Department department) {
        System.out.println("Maximum salary employee is : " + employeeBook.employeeWithMaxSalary(department));
    }
    public static void outputAverageSalaries() {
        System.out.println("The average value of salaries is : " + employeeBook.averageSalaries());
    }
    public static void outputAverageSalaries(Department department) {
        System.out.println("The average value of salaries is : " + employeeBook.averageSalaries(department));
    }
    public static void outputFullNameOfEmployees() {
        System.out.println("Full name of employees:\n" + employeeBook.fullNamesEmployees());
    }

}