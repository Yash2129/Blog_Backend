package com.yash.blog_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.blog_app.entity.Blog;
import com.yash.blog_app.repository.BlogRepository;

@Service
public class BlogService {
    
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getAllBlog(){
        return blogRepository.findAll();
    }

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public List<Blog> findBlogByEmail(String email){
        return blogRepository.findBlogByEmail(email);
    }
}
