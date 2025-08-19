package com.loginpage.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	@Autowired
	UserDetailsService userDetails;
	@Bean
	public PasswordEncoder password() {
		return new BCryptPasswordEncoder();
	}	
	@Bean
	public AuthenticationManager auth(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}	
	@SuppressWarnings("removal")
	@Bean
	public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		.csrf()
		.disable()
		.authorizeHttpRequests(auth -> auth
		.requestMatchers("/admin/**").hasRole("ADMIN")
		.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
		.requestMatchers("/", "/login", "/register").permitAll()
		.anyRequest().authenticated()
		)
		.formLogin(form -> form.loginPage("/login")
		.defaultSuccessUrl("/welcome", true)
		.permitAll())
	   .logout(logout -> logout
	   .logoutSuccessUrl("/login?logout")
	   .invalidateHttpSession(true)
	   .deleteCookies("JSESSIONID"));	
		return http.build();
	}
			public static void main(String[] args) {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				//Scanner sc= new Scanner(System.in);
				//String rawPassword = sc.nextLine();
				String rawPassword = "admin123";
				String encodedPassword = encoder.encode(rawPassword);
				System.out.println("BCrypt Encoded Password: "+encodedPassword);		
	}
}
