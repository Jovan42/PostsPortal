package jovan.sf_62_2017.postsportal.controllers;

import jovan.sf_62_2017.postsportal.pojo.Post;
import jovan.sf_62_2017.postsportal.pojo.User;
import jovan.sf_62_2017.postsportal.services.interfaces.IPostsService;
import jovan.sf_62_2017.postsportal.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public List<User> get() {
        return userService.get();
    }

    @RequestMapping(value = "users/{userName}", method = RequestMethod.GET, produces = "application/json")
    public User get(@PathVariable String userName){
        return  userService.get(userName);
    }

    @RequestMapping(value = "users/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public User post(@RequestBody User product){
        return userService.add(product);
    }

    @RequestMapping(value = "users/", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public User put(@RequestBody User product){
        return userService.update(product);
    }

    @RequestMapping(value = "users/{userName}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable String userName){
        return userService.delete(userName);
    }
}
