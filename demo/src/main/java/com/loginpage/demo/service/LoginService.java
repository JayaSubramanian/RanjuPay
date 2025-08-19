package com.loginpage.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loginpage.demo.UserDetails.UserEntity;
@Service
public class LoginService {	
	  @Autowired 
	  private UserRepository repo; 
	  public boolean validateUser(String
	  userid, String password) 
	  { 
		  UserEntity user =repo.findByUsernameAndPassword(userid, password); 
		  return user!= null; 
		 }

}


