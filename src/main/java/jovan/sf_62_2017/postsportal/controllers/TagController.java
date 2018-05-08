package jovan.sf_62_2017.postsportal.controllers;

import jovan.sf_62_2017.postsportal.pojo.Tag;
import jovan.sf_62_2017.postsportal.services.interfaces.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
    @RequestMapping("/api")
public class TagController {
    private ITagService tagService;

    @Autowired
    public void setTagService(ITagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping(value = "/tags", method = RequestMethod.GET, produces = "application/json")
    public List<Tag> get() {
        return tagService.get();
    }

    @RequestMapping(value = "/tags/post={id}", method = RequestMethod.GET, produces = "application/json")
    public List<Tag> getForPost(@PathVariable int id) {
        return tagService.getForPost(id);
    }

    @RequestMapping(value = "tags/{id}", method = RequestMethod.GET, produces = "application/json")
    public Tag get(@PathVariable int id){
        return  tagService.get(id);
    }

    @RequestMapping(value = "/tags/",  method = RequestMethod.POST)
    public Tag post(@RequestBody Tag product){
        return tagService.add(product);
    }

    @RequestMapping(value = "/tags/", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public Tag put(@RequestBody Tag product){
        return tagService.update(product);
    }

    @RequestMapping(value = "tags/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id) {
        return tagService.delete(id);
    }

    @RequestMapping(value = "/proba/", method = RequestMethod.POST)
    public boolean proba(){
        return true;
    }
}
