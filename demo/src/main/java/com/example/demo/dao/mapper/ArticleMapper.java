package com.example.demo.dao.mapper;
import com.example.demo.dao.domain.Article;
import com.example.demo.dao.dto.ArticleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring",uses={CommentMapper.class})
public interface ArticleMapper {
    ArticleDto articleToArticleDTO (Article artcl);
    Article  articleDTOToArticle (ArticleDto artcl);
    List<ArticleDto> mapToArticles(List<Article> articleEntityList);
}
