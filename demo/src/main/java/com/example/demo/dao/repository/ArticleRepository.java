package com.example.demo.dao.repository;

import com.example.demo.dao.domain.Article;
import com.example.demo.dao.dto.ArticleDto;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
    @Query("SELECT a FROM Article a WHERE a.title LIKE %?1%")
    Page<Article> searchByKeyword(String keyword, Pageable pageable);

    Page<Article> getAllBy(Pageable pageable);
}
