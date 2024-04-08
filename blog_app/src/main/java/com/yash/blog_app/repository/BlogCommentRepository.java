package com.yash.blog_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.blog_app.entity.BlogComment;
import java.util.List;


@Repository
public interface BlogCommentRepository extends JpaRepository<BlogComment,Long>{
    
    @Query("SELECT c FROM BlogComment c WHERE c.blog.id = :blog_id")
    List<BlogComment> findCommentsByBlogId(String blog_id);
}
