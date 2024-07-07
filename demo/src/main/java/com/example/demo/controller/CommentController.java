package com.example.demo.controller;

import com.example.demo.dao.dto.CommentDto;
import com.example.demo.exceptionsHandler.exceptions.CommentNotFoundException;
import com.example.demo.service.serviceImpl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/save")
    public CommentDto saveComment(@RequestBody CommentDto comment) {
        return commentService.saveComment(comment);
    }

    @PutMapping(value = "/update/{id}")
    public CommentDto updateComment(@RequestBody CommentDto comment, @PathVariable Long id) {
        return commentService.updateComment(comment, id);
    }

    @GetMapping(value="/getAll")
    public List<CommentDto> findAllComments(){
        return commentService.findAllComments();
    }
    @DeleteMapping(value="/delete/{id}")
    public String deleteComment(@PathVariable Long id){
        return commentService.deleteComment(id);
    }

    @GetMapping(value="getById/{id}")
    public CommentDto findById(@PathVariable Long id)throws CommentNotFoundException {
        return commentService.findCommentById(id) ;
    }
}
