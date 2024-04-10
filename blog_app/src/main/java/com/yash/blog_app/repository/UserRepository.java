package com.yash.blog_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.blog_app.entity.Users;




@Repository
public interface UserRepository extends JpaRepository<Users,Long>{

    Optional<Users> findByUsername(String username);
}
