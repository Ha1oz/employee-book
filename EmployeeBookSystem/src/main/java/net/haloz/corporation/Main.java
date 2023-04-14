package net.haloz.corporation;

import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.exceptions.HashMapEmployeeException;
import net.haloz.corporation.service.HashMapEmployee;

public class Main {
    static HashMapEmployee hashMapEmployee = new HashMapEmployee();
    public static void main(String[] args) {

        Employee employee1 = new Employee("Oleg", "Barkalov", "Alenovich");
        Employee employee2 = new Employee("Alex", "Mironov", "Ivanovich", "1", 200000d);
        Employee employee3 = new Employee("Alen", "Barkalov", "Albertovich", "2", 400000d);

        try {
            hashMapEmployee.addEmployee(employee1);
            hashMapEmployee.addEmployee(employee2);
            hashMapEmployee.addEmployee(employee3);

        } catch (HashMapEmployeeException e) {
            throw new RuntimeException(e);
        }

//        System.out.println(employee1.toString());
//        System.out.println(employee2.toString());

        outputEmployees();
        outputEmployeesMonthlyPayment();
        outputEmployeeWithMinSalary();
        outputEmployeeWithMaxSalary();
        outputAverageSalaries();
        outputFullNameOfEmployees();

        System.out.println();

    }

    public static void outputEmployees() {
        System.out.println("--------------------------------------------Employees--------------------------------------------");
        for (Employee employee : hashMapEmployee.getAllEmployees()) {
            System.out.println(employee.toString());
        }
        System.out.println("-------------------------------------------------------------------------------------------------");
    }
    public static void outputEmployeesMonthlyPayment() {
        System.out.println("The payout for the month for all employees will be : " + hashMapEmployee.monthlyPaymentAmount());
    }
    public static void outputEmployeeWithMinSalary() {
        System.out.println("Minimum salary employee is : " + hashMapEmployee.employeeWithMinSalary());
    }

    public static void outputEmployeeWithMaxSalary() {
        System.out.println("Maximum salary employee is : " + hashMapEmployee.employeeWithMaxSalary());
    }
    public static void outputAverageSalaries() {
        System.out.println("The average value of salaries is : " + hashMapEmployee.averageSalaries());
    }
    public static void outputFullNameOfEmployees() {
        System.out.println("Full name of employees:\n" + hashMapEmployee.fullNamesEmployees());
    }

}