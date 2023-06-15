package net.haloz.corporation.exceptions;

public class EmployeeInvalidDataException extends RuntimeException {
    public EmployeeInvalidDataException(String message) {
        super(message);
    }
}
