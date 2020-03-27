package com.mrcruztech.mongodb.repository;

import com.mrcruztech.mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
