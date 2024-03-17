package com.estsoft.blog_project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments = new ArrayList<>();

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public ArticleResponse mapper() {
        return new ArticleResponse(id, title, content);
    }

}
