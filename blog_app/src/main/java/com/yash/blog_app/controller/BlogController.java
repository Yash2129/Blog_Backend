package com.yash.blog_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.blog_app.entity.Blog;
import com.yash.blog_app.service.BlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping()
    public ResponseEntity<List<Blog>> getAllBlog() {
        List<Blog> allBlog = blogService.getAllBlog();

        if (allBlog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Blog>>(allBlog, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Blog>> getBlogByUsername(@PathVariable String username) {
        List<Blog> blog = blogService.findBlogByUsername(username);

        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {

        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Blog blog2 = blogService.createBlog(blog);
        return new ResponseEntity<Blog>(blog2, HttpStatus.CREATED);
    }

}
