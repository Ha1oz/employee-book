package net.haloz.corporation;

import net.haloz.corporation.entities.Employee;
import net.haloz.corporation.exceptions.HashMapEmployeeException;
import net.haloz.corporation.service.HashMapEmployee;

public class Main {
    static HashMapEmployee hashMapEmployee = new HashMapEmployee();
    public static void main(String[] args) {

        //HashMapEmployee hashMapEmployee = new HashMapEmployee();

        System.out.println("--------------------------------------------");

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

        System.out.println();

    }

    public static void outputEmployees() {
        for (Employee employee : hashMapEmployee.getAllEmployees()) {
            System.out.println(employee.toString());
        }
    }
    public static void outputEmployeesMonthlyPayment() {
        System.out.println("The payout for the month for all employees will be : " + hashMapEmployee.monthlyPaymentAmount());
    }

}