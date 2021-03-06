package com.mrcruztech.mongodb.resources;

import com.mrcruztech.mongodb.domain.Post;
import com.mrcruztech.mongodb.domain.User;
import com.mrcruztech.mongodb.dto.UserDTO;
import com.mrcruztech.mongodb.resources.util.URL;
import com.mrcruztech.mongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> posts = postService.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        List<Post> posts = postService.fullSearch(text, min, max);
        return ResponseEntity.ok().body(posts);
    }
}
