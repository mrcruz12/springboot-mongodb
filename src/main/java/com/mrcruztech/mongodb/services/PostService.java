package com.mrcruztech.mongodb.services;

import com.mrcruztech.mongodb.domain.Post;
import com.mrcruztech.mongodb.domain.User;
import com.mrcruztech.mongodb.repository.PostRepository;
import com.mrcruztech.mongodb.resources.PostResource;
import com.mrcruztech.mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepo;

    public Post findById(String id){
        Optional<Post> obj = postRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text){
        return postRepo.searchTitle(text);
    }

}
