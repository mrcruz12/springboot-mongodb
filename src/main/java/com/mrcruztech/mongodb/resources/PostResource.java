package com.mrcruztech.mongodb.resources;

import com.mrcruztech.mongodb.domain.Post;
import com.mrcruztech.mongodb.domain.User;
import com.mrcruztech.mongodb.dto.UserDTO;
import com.mrcruztech.mongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {


    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {

        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
}
