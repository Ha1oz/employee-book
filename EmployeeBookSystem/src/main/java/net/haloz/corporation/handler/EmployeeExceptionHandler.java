package net.haloz.corporation.handler;

import net.haloz.corporation.exceptions.EmployeeAlreadyAddedException;
import net.haloz.corporation.exceptions.EmployeeInvalidDataException;
import net.haloz.corporation.exceptions.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeExceptionHandler.class);

    @ExceptionHandler(EmployeeInvalidDataException.class)
    public ResponseEntity<Object> handleEmployeeInvalidDataException(EmployeeInvalidDataException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("Employee data is invalid.", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("Employee is not found.", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    public ResponseEntity<Object> handleEmployeeAlreadyAddedException(EmployeeAlreadyAddedException e) {
        LOGGER.error(e.toString());
        return new ResponseEntity<>("Employee is already added.", HttpStatus.BAD_REQUEST);
    }
}
