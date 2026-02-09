package com.enzima01.webservice.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.enzima01.webservice.domain.User;
import com.enzima01.webservice.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User u1 = new User(null, "Enzo", "enzo@gmail.com");
		User u2 = new User(null, "Maria", "maria@gmail.com");
		User u3 = new User(null, "Bob", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));

	}

}
