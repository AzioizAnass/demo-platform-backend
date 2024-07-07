package com.example.demo.exceptionsHandler.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String email) {
        super("The email "+ email +" does not belong to any user.");
    }
}
