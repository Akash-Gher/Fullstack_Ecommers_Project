package com.skyfashion.backend;


import com.skyfashion.backend.security.MyUserDetailsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	//	@Bean
//	public MyUserDetailsService myUserDetailsService() {
//		return new MyUserDetailsService();
//	}



	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailsService(); // (1)
	}


	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


}
