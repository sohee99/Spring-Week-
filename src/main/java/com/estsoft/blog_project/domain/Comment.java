package com.estsoft.blog_project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String body;

    @CreationTimestamp
    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "article_id") //외래키컬럼
    private Article article;


    public void setArticleId(Article article) {
        this.article = article;
    }

}
