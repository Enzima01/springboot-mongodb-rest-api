package com.enzima01.webservice.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.enzima01.webservice.domain.Post;
import com.enzima01.webservice.domain.User;
import com.enzima01.webservice.dto.AuthorDTO;
import com.enzima01.webservice.repositories.PostRepository;
import com.enzima01.webservice.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User u1 = new User(null, "Enzo", "enzo@gmail.com");
		User u2 = new User(null, "Maria", "maria@gmail.com");
		User u3 = new User(null, "Bob", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(u1, u2, u3));

		Post post1 = new Post(null, sdf.parse("01/01/2026"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u2));
		Post post2 = new Post(null, sdf.parse("18/02/2026"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u1));

		postRepository.saveAll(Arrays.asList(post1, post2));
		
		
		u2.getPost().addAll(Arrays.asList(post1));
		u1.getPost().addAll(Arrays.asList(post2));
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		
	}

}
