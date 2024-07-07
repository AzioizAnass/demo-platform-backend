package com.example.demo.dao.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CommentDto {
    private Long commentId;
    private String commentDate;
    private String commentContent;
    private ArticleDto article;
    private UserDto user;
}
