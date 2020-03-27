package com.mrcruztech.mongodb.services;

import com.mrcruztech.mongodb.domain.User;
import com.mrcruztech.mongodb.dto.UserDTO;
import com.mrcruztech.mongodb.repository.UserRepository;
import com.mrcruztech.mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> findAll(){
        return userRepo.findAll();
    }

    public User findById(String id){
        Optional<User> obj = userRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User user){
        return userRepo.save(user);
    }

    public User fromDTO(UserDTO userDto){
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }
}
