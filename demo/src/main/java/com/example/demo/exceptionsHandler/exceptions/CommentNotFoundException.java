package com.example.demo.exceptionsHandler.exceptions;

public class CommentNotFoundException extends Exception{
    public CommentNotFoundException(Long id) {
        super("Message : " +id+ " Not Found !");
    }
}
