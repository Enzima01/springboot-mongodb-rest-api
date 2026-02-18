package com.enzima01.webservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.enzima01.webservice.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
