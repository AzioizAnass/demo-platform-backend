package com.example.demo.service.serviceImpl;
import com.example.demo.dao.domain.Article;
import com.example.demo.dao.mapper.CommentMapper;

import com.example.demo.dao.dto.ArticleDto;
import com.example.demo.dao.repository.ArticleRepository;
import com.example.demo.dao.mapper.ArticleMapper;


import com.example.demo.exceptionsHandler.exceptions.ArticleNotFoundException;
import com.example.demo.service.serviceInterfaces.IArticleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ArticleService implements IArticleService{
    @Autowired
    ArticleRepository articleRepository ;
    @Autowired
    ArticleMapper articleMapper ;

    @Override
    public ArticleDto saveArticle(ArticleDto article){
        Article articleSaved = articleMapper.articleDTOToArticle(article) ;
        return articleMapper.articleToArticleDTO(articleRepository.save(articleSaved)) ;

    }

    @Override
    public ArticleDto updateArticle(ArticleDto article, Long id) {
        Article articleSaved = articleMapper.articleDTOToArticle(article) ;
        articleSaved.setArticleId(id);
        return articleMapper.articleToArticleDTO(articleRepository.save(articleSaved)) ;
    }
    @Override
    public ArticleDto findArticleById(Long id) throws ArticleNotFoundException {
        ArticleDto article = articleMapper.articleToArticleDTO(articleRepository.findById(id).orElseThrow(()->new ArticleNotFoundException(id)));
        return article ;
    }

    @Override
    public String deleteArticle(Long id) {
        articleRepository.deleteById(id);
        return "article deleted !";
    }

    @Override
    public List<ArticleDto> findAllArticles() {
        return articleMapper.mapToArticles(articleRepository.findAll());
    }

    @Override
    public Page<ArticleDto> searchArticlesByKeyword(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return articleRepository.searchByKeyword(keyword, pageable).map(articleMapper::articleToArticleDTO);
    }
    @Override
    public Page<ArticleDto> findArticlesByPage(Integer pageNo , Integer pageSize) {
        Pageable pagebale = PageRequest.of(pageNo,pageSize);
        Page<Article> articlePage = articleRepository.getAllBy(pagebale) ;
        return articlePage.map(articleMapper::articleToArticleDTO) ;
    }

}
