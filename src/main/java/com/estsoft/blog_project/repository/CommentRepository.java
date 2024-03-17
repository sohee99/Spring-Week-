package com.estsoft.blog_project.repository;

import com.estsoft.blog_project.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByArticle_Id(Long articleId);
}
