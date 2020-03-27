package com.mrcruztech.mongodb.repository;

import com.mrcruztech.mongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
