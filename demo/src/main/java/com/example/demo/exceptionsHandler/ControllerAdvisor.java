package com.example.demo.exceptionsHandler;

import com.example.demo.exceptionsHandler.exceptions.ArticleNotFoundException;
import com.example.demo.exceptionsHandler.exceptions.CommentNotFoundException;
import com.example.demo.exceptionsHandler.exceptions.IncorrectPasswordException;
import com.example.demo.exceptionsHandler.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(ArticleNotFoundException.class)
    public ResponseEntity<Object> handleArticleNotFoundException(ArticleNotFoundException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Timstamp : ", LocalDateTime.now());
        body.put("Message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<Object> handleCommentNotFoundException(CommentNotFoundException ex){
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("Timstamp : ", LocalDateTime.now());
        body.put("Message : ", ex.getMessage());
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex){
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("Timstamp : ", LocalDateTime.now());
        body.put("Message : ", ex.getMessage());
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<Object> handleIncorrectPasswordException(IncorrectPasswordException ex){
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("Timstamp : ", LocalDateTime.now());
        body.put("Message : ", ex.getMessage());
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }
}
