package com.example.demo.service.serviceInterfaces;

import com.example.demo.dao.dto.CommentDto;
import com.example.demo.exceptionsHandler.exceptions.CommentNotFoundException;

import java.util.List;

public interface ICommentService {
    CommentDto saveComment(CommentDto cmnt);

    CommentDto updateComment(CommentDto cmntDto, Long id);

    String deleteComment(Long id);

    List<CommentDto> findAllComments();

    CommentDto findCommentById(long id) throws CommentNotFoundException;

}
