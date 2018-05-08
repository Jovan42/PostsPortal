package jovan.sf_62_2017.postsportal.controllers;

import jovan.sf_62_2017.postsportal.pojo.Post;
import jovan.sf_62_2017.postsportal.services.interfaces.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {
    private IPostsService postsService;

    @Autowired
    public void setPostsService(IPostsService postsService) {
        this.postsService = postsService;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET, produces = "application/json")
    public List<Post> get() {
        return postsService.get();
    }

    @RequestMapping(value = "posts/{id}", method = RequestMethod.GET, produces = "application/json")
    public Post get(@PathVariable int id){
        return  postsService.get(id);
    }

    @RequestMapping(value = "posts/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Post post(@RequestBody Post product){
        return postsService.add(product);
    }

    @RequestMapping(value = "posts/", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public Post put(@RequestBody Post product){
        return postsService.update(product);
    }

    @RequestMapping(value = "posts/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id){
        return postsService.delete(id);
    }

    @RequestMapping(value = "users/{userName}/posts", method = RequestMethod.GET, produces = "application/json")
    public List<Post> getUserPosts(@PathVariable String userName){
        return postsService.getFromUser(userName);
    }
}
