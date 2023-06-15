package net.haloz.corporation;

public class EmployeeTest {
//    EmployeeBook employeeBook = new EmployeeBook();
//
//    @Test
//    void getEmployeeDataInBase() {
//
//        String name = "Oleg";
//        String surname = "Barkalov";
//        String fathersName = "Alenovich";
//        Double salary = 23000d;
//        Integer id = 2;
//
//        try {
//            employeeBook.addEmployee(surname,name,fathersName,Department.DEPARTMENT_1,salary);
//        } catch (EmployeeException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println(employeeBook.getAllEmployees());
//
//        assertAll(() -> assertEquals(surname,employeeBook.getEmployee(id).getSurname()),
//                () -> assertEquals(name,employeeBook.getEmployee(id).getName()),
//                () -> assertEquals(fathersName,employeeBook.getEmployee(id).getFathersName()),
//                () -> assertEquals(Department.DEPARTMENT_1,employeeBook.getEmployee(id).getDepartment()),
//                () -> assertEquals(salary,employeeBook.getEmployee(id).getSalary()));
//    }
//    @Test
//    void notCreateEmployeeWithInvalidData() {
//        assertThrows(EmployeeException.class,
//                () -> new Employee("Name", "Surname", "FathersName", null, 2000d));
//        assertThrows(EmployeeException.class,
//                () -> new Employee("Name", "Surname", "FathersName", Department.DEPARTMENT_1, -2000d));
//    }
//    @Test
//    void employeeDoesNotExistInBase() {
//
//        try {
//            employeeBook.addEmployee("Alex", "Mironov", "Ivanovich",
//                    Department.DEPARTMENT_2, 200000d);
//        } catch (EmployeeException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println(employeeBook.getAllEmployees());
//
//        assertThrows(HashMapEmployeeException.class,
//                () -> employeeBook.deleteEmployee(-1));
//
//    }
//    @Test
//    void employeeWasDeleted() {
//        Integer id = 0;
//        try {
//            employeeBook.addEmployee("Alexander", "Murno", "Vitaliych",
//                    Department.DEPARTMENT_5, 40000d);
//            employeeBook.addEmployee("Alex", "Mironov", "Ivanovich",
//                    Department.DEPARTMENT_2, 200000d);
//            System.out.println(employeeBook.getAllEmployees());
//            employeeBook.deleteEmployee(id);
//        } catch (EmployeeException | HashMapEmployeeException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(employeeBook.getAllEmployees());
//        assertThrows(HashMapEmployeeException.class,
//                () -> employeeBook.deleteEmployee(id));
//    }
//    @Test
//    void employeeSalaryWasChangedInTwoWays() {
//        Integer id = 5;
//        try {
//            employeeBook.addEmployee("Alexander", "Murno", "Vitaliych",
//                    Department.DEPARTMENT_5, 40000d);
//
//            System.out.println(employeeBook.getAllEmployees());
//
//            employeeBook.changeEmployeeSalary(id, 200000d);
//            assertEquals(200000d, employeeBook.getEmployee(id).getSalary());
//            employeeBook.getEmployee(id).setSalary(500000d);
//            assertEquals(500000d, employeeBook.getEmployee(id).getSalary());
//        } catch (EmployeeException | HashMapEmployeeException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    @Test
//    void employeeDepartmentWasChangedInTwoWays() {
//        Integer id = 3;
//        try {
//            employeeBook.addEmployee("Alexander", "Murno", "Vitaliych",
//                    Department.DEPARTMENT_5, 40000d);
//
//            System.out.println(employeeBook.getAllEmployees());
//
//            employeeBook.changeEmployeeDepartment(id, Department.DEPARTMENT_1);
//            assertEquals(Department.DEPARTMENT_1, employeeBook.getEmployee(id).getDepartment());
//            employeeBook.getEmployee(id).setDepartment(Department.DEPARTMENT_3);
//            assertEquals(Department.DEPARTMENT_3, employeeBook.getEmployee(id).getDepartment());
//        } catch (EmployeeException | HashMapEmployeeException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
