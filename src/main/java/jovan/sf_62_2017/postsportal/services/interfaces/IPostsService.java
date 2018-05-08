package jovan.sf_62_2017.postsportal.services.interfaces;

import jovan.sf_62_2017.postsportal.pojo.Post;

import java.util.List;

public interface IPostsService extends IGenericService<Post, Integer> {
    List<Post> getFromUser(String userName);
}
