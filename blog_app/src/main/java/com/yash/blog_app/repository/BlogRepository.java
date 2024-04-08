package com.yash.blog_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.blog_app.entity.Blog;
import java.util.List;


@Repository
public interface BlogRepository extends JpaRepository<Blog,Long>{
    
    @Query("SELECT b FROM Blog b WHERE b.user.email = :email")
    List<Blog> findBlogByEmail(String email);

}
