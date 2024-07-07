package com.example.demo.dao.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ArticleDto {
    private long articleId;
    private String content;

    private String creationDate;
    private String title;
    private Set<CommentDto> comments ;
}
