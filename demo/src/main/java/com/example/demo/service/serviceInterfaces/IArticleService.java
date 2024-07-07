package com.example.demo.service.serviceInterfaces;

import com.example.demo.dao.domain.Article;
import com.example.demo.dao.dto.ArticleDto;
import com.example.demo.exceptionsHandler.exceptions.ArticleNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IArticleService {
    ArticleDto saveArticle(ArticleDto art);
    ArticleDto updateArticle(ArticleDto art, Long id);
    ArticleDto findArticleById(Long id) throws ArticleNotFoundException;
    String deleteArticle(Long id);
    List<ArticleDto> findAllArticles();
    //Page<ArticleDto> findAritclesByPage(Integer pageNo, Integer pageSize);
    public Page<ArticleDto> searchArticlesByKeyword(String keyword, int page, int size);
    public Page<ArticleDto> findArticlesByPage(Integer pageNo , Integer paegSize);
}
