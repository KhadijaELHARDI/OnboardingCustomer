package com.example.processclients.exceptions;

public class DeletedCustomerNotFoundException extends Exception{
    public DeletedCustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeletedCustomerNotFoundException(String message) {
        super(message);
    }
}
