package com.mrcruztech.mongodb.services;

import com.mrcruztech.mongodb.domain.User;
import com.mrcruztech.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> findAll(){
        return userRepo.findAll();
    }
}
