package com.mrcruztech.mongodb.config;

import com.mrcruztech.mongodb.domain.Post;
import com.mrcruztech.mongodb.domain.User;
import com.mrcruztech.mongodb.dto.AuthorDTO;
import com.mrcruztech.mongodb.dto.CommentDTO;
import com.mrcruztech.mongodb.repository.PostRepository;
import com.mrcruztech.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PostRepository postRepo;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepo.deleteAll();
        postRepo.deleteAll();

        User ananda = new User(null, "Ananda N A da Cruz", "ananda@gmail.com");
        User marco = new User(null, "Marco A R da Cruz", "marco@gmail.com");
        User wilian = new User(null, "Wilian R da Cruz", "wilian@gmail.com");
        User lucas = new User(null, "Lucas R da Cruz", "lucas@gmail.com");

        userRepo.saveAll(Arrays.asList(ananda, marco, wilian, lucas));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para SJC", new AuthorDTO(ananda));
        Post post2 = new Post(null, sdf.parse("21/03/2020"), "6 meses", "Hoje fazemos 6 meses de casados!", new AuthorDTO(ananda));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(wilian));

        CommentDTO c2 = new CommentDTO("Parabens ao casal!", sdf.parse("21/03/2020"), new AuthorDTO(wilian));
        CommentDTO c3 = new CommentDTO("Felicidades!", sdf.parse("21/03/2020"), new AuthorDTO(marco));

        post1.getComments().addAll(Arrays.asList(c1));
        post2.getComments().addAll(Arrays.asList(c2, c3));

        postRepo.saveAll(Arrays.asList(post1, post2));

        ananda.getPosts().addAll(Arrays.asList(post1, post2));
        userRepo.save(ananda);
    }
}

