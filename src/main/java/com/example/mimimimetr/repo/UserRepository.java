package com.example.mimimimetr.repo;

import com.example.mimimimetr.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select user_name from usr where user_name = :username order by user_name desc limit 1", nativeQuery = true)
    String findByUserName(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "update User u set u.choice = true where u.userName = :username")
    void updateUsersByChoice(@Param("username") String username);

    @Query(value = "select u.choice from User u where u.userName = :username")
    boolean findUsersByCheckChoice(@Param("username") String username);

    @Override
    <S extends User> S save(S s);
}
