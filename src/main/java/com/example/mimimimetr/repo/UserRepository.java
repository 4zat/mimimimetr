package com.example.mimimimetr.repo;

import com.example.mimimimetr.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select u.userName, u.password from User u where u.userName = :username")
    User findByUserName(@Param("username") String username);
}
