package com.example.mimimimetr.repo;

import com.example.mimimimetr.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
