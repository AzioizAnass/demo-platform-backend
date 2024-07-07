package com.example.demo.service.serviceImpl;

import com.example.demo.dao.domain.Comment;
import com.example.demo.dao.dto.CommentDto;
import com.example.demo.dao.mapper.CommentMapper;
import com.example.demo.dao.repository.CommentRepository;
import com.example.demo.exceptionsHandler.exceptions.CommentNotFoundException;
import com.example.demo.service.serviceInterfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService implements ICommentService {
    @Autowired
    CommentRepository commentRepository ;
    @Autowired
    CommentMapper commentMapper ;

    @Override
    public CommentDto saveComment(CommentDto cmnt) {
        Comment commentToSave = commentMapper.CommentDTOToComment(cmnt) ;
        return commentMapper.CommentToCommentDTO(commentRepository.save(commentToSave));
    }

    @Override
    public CommentDto updateComment(CommentDto cmntDto, Long id) {
        Comment commentToSave = commentMapper.CommentDTOToComment(cmntDto) ;
        commentToSave.setCommentId(id);
        return commentMapper.CommentToCommentDTO(commentRepository.save(commentToSave));
    }
    @Override
    public String deleteComment(Long id) {
        commentRepository.deleteById(id);
        return "article deleted !";
    }
    @Override
    public List<CommentDto> findAllComments() {
        return commentMapper.mapToComments(commentRepository.findAll());
    }

    @Override
    public CommentDto findCommentById(long id) throws CommentNotFoundException {
        CommentDto comment = commentMapper.CommentToCommentDTO(commentRepository.findById(id).orElseThrow(()-> new CommentNotFoundException(id)));
        return comment;
    }
}
