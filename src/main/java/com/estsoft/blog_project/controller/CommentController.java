package com.estsoft.blog_project.controller;

import com.estsoft.blog_project.domain.Article;
import com.estsoft.blog_project.domain.Comment;
import com.estsoft.blog_project.domain.CommentResponse;
import com.estsoft.blog_project.repository.BlogRepository;
import com.estsoft.blog_project.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    // ArticleRepository 주입
    private BlogRepository blogRepository;

    //하나의 게시글에 대한 댓글 리스트 조회
    @GetMapping("/comments/{articleId}")
    public ResponseEntity<List<CommentResponse>> showCommentsByArticleId(@PathVariable Long articleId) {
        List<Comment> comments = commentRepository.findByArticle_Id(articleId);
        List<CommentResponse> commentResponses = comments.stream()
                .map(comment -> new CommentResponse(comment.getId(), comment.getBody(), comment.getCreated_at()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(commentResponses);
    }

    @PostMapping("/comments/{articleId}")
    public ResponseEntity<CommentResponse> createComment(@PathVariable Long articleId, @RequestBody Comment comment){
        Article article = blogRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article not found with id " + articleId));
        comment.setArticle(article);
        Comment saveComment = commentRepository.save(comment);
        CommentResponse commentResponse = new CommentResponse(saveComment.getId(),saveComment.getBody(),saveComment.getCreated_at());
        return ResponseEntity.status(HttpStatus.CREATED).body(commentResponse);
    }
}
