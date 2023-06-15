package net.haloz.corporation.exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String message)
    {
        super(message);
    }
}
