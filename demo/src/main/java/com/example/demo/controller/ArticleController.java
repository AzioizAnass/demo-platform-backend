package com.example.demo.controller;

import com.example.demo.dao.dto.ArticleDto;
import com.example.demo.dao.dto.SearchRequest;
import com.example.demo.exceptionsHandler.exceptions.ArticleNotFoundException;
import com.example.demo.service.serviceImpl.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("articles")
public class ArticleController {
    @Autowired
    ArticleService articleService  ;
    @Autowired
    ArticleController(ArticleService articleService){
        this.articleService=articleService ;
    }
    @PostMapping(value = "/save")
    public ArticleDto saveArticle(@RequestBody ArticleDto article){
        return articleService.saveArticle(article);
    }
    @PutMapping(value = "/update/{id}")
    public ArticleDto updateArticle(@RequestBody ArticleDto article,@PathVariable Long id){
        return articleService.updateArticle(article,id);
    }
    @GetMapping (value = "/getAll")
    public List<ArticleDto> findAllArticles(){
        return articleService.findAllArticles();}
    @DeleteMapping(value="/delete/{id}")
    public String deleteArticle(@PathVariable Long id){
        return articleService.deleteArticle(id);
    }
    @GetMapping(value="/getByPage/{pageSize}/{pageNo}")
    public Page<ArticleDto> getArticleByPage(@PathVariable Integer pageSize,@PathVariable Integer pageNo ){
        return articleService.findArticlesByPage(pageNo,pageSize);
    }
    @GetMapping(value="/search/{pageSize}/{pageNo}")
    public Page<ArticleDto> searchArticleByPage(@RequestParam String keyword , @PathVariable Integer pageSize, @PathVariable Integer pageNo ){
        return articleService.searchArticlesByKeyword(keyword,pageNo,pageSize);
    }
    @GetMapping(value="/getById/{id}")
    public ArticleDto getArticleByPage(@PathVariable Long id ) throws ArticleNotFoundException {
        return articleService.findArticleById(id);
    }


}
