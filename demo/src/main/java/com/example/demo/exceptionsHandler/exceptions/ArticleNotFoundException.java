package com.example.demo.exceptionsHandler.exceptions;

public class ArticleNotFoundException extends Exception{
    public ArticleNotFoundException(Long id) {
        super("Article : "+ id +" Not Found");
    }
}
