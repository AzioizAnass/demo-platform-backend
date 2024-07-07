package com.example.demo.exceptionsHandler.exceptions;

public class IncorrectPasswordException extends Exception{
    public IncorrectPasswordException() {
        super("Incorrect Password");
    }
}
