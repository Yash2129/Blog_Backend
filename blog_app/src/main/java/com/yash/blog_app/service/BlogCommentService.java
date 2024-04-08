package com.yash.blog_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.blog_app.entity.BlogComment;
import com.yash.blog_app.repository.BlogCommentRepository;

@Service
public class BlogCommentService {

    @Autowired
    private BlogCommentRepository blogCommentRepository;

    public List<BlogComment> getAllCommentsForBlog(String blog_id) {
        List<BlogComment> blogComments = blogCommentRepository.findCommentsByBlogId(blog_id);
        return blogComments;
    }

    public BlogComment addComment(BlogComment blogComment) {
        return blogCommentRepository.save(blogComment);
    }
}
