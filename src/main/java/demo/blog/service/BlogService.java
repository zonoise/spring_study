package demo.blog.service;

import demo.blog.domain.Post;
import demo.blog.domain.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zonoise on 15/04/01.
 */
@Component
public class BlogService {
    @Autowired
    PostRepository postRepository;

    Iterable<Post> getPost(){
        return postRepository.findAll();
    }



}
