package jovan.sf_62_2017.postsportal.controllers;

import jovan.sf_62_2017.postsportal.pojo.Comment;
import jovan.sf_62_2017.postsportal.services.interfaces.ICommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentController {
    private ICommentsService commentsService;

    @Autowired
    public void setCommentsService(ICommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET, produces = "application/json")
    public List<Comment> get() {
        return commentsService.get();
    }

    @RequestMapping(value = "/comments/post={id}", method = RequestMethod.GET, produces = "application/json")
    public List<Comment> getForPost(@PathVariable int id) {
        return commentsService.getForPost(id);
    }

    @RequestMapping(value = "comments/{id}", method = RequestMethod.GET, produces = "application/json")
    public Comment get(@PathVariable int id){
        return  commentsService.get(id);
    }

    @RequestMapping(value = "comments/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Comment post(@RequestBody Comment product){
        return commentsService.add(product);
    }

    @RequestMapping(value = "comments/", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public Comment put(@RequestBody Comment product){
        return commentsService.update(product);
    }

    @RequestMapping(value = "comments/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id){
        return commentsService.delete(id);
    }
}
