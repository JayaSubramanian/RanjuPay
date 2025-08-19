package com.loginpage.demo.UserDetails;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import com.loginpage.demo.service.UserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {	
	@Autowired
	private UserRepository repo;	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		UserEntity user = repo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not Found");
		}		
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(),
				user.getPassword(),
				List.of(new SimpleGrantedAuthority("ROLE_" +user.getRole()))
				);		
	}
}
