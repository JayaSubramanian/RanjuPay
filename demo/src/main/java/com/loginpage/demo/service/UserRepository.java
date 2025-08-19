package com.loginpage.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginpage.demo.UserDetails.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	 UserEntity findByUsernameAndPassword(String username, String password);
	 UserEntity findByUsername(String username);
	
  }

