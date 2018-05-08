package jovan.sf_62_2017.postsportal.services.interfaces;

import jovan.sf_62_2017.postsportal.pojo.Comment;

import java.util.List;

public interface ICommentsService extends IGenericService<Comment, Integer> {
    List<Comment> getForPost(Integer postID);
}
