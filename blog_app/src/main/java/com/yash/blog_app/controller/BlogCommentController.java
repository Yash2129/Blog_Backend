package com.yash.blog_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.blog_app.entity.BlogComment;
import com.yash.blog_app.service.BlogCommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/blog/comments")
public class BlogCommentController {

    @Autowired
    private BlogCommentService blogCommentService;

    @GetMapping("/{blog_id}")
    public ResponseEntity<List<BlogComment>> getAllCommentsForBlog(@PathVariable String blog_id) {
        if (blog_id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<BlogComment> comments = blogCommentService.getAllCommentsForBlog(blog_id);
        return new ResponseEntity<List<BlogComment>>(comments, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BlogComment> addComment(@RequestBody BlogComment blogComment) {
        if (blogComment == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        blogCommentService.addComment(blogComment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
