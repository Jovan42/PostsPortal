package jovan.sf_62_2017.postsportal.services.interfaces;

import jovan.sf_62_2017.postsportal.pojo.Tag;

import java.util.List;

public interface ITagService extends IGenericService<Tag, Integer> {
    List<Tag> getForPost(Integer postId);
}
