package com.project.gym.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.gym.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmailAndPassword(String email,String password);
}
