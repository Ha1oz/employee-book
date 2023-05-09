package net.haloz.corporation;

import net.haloz.corporation.entities.Department;
import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.service.EmployeeBook;

import java.util.List;

public class Main {
    static EmployeeBook employeeBook = new EmployeeBook();
    public static void main(String[] args) {}

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