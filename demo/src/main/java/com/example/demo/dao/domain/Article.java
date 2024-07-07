package com.example.demo.dao.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long articleId;
    @Column
    private String content;

    @Column
    private String creationDate;

    @Column
    private String title;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    private Set<Comment> comments ;
}
