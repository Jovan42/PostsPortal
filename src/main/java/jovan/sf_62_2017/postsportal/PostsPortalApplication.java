package jovan.sf_62_2017.postsportal;

import jovan.sf_62_2017.postsportal.pojo.Comment;
import jovan.sf_62_2017.postsportal.pojo.Post;
import jovan.sf_62_2017.postsportal.pojo.Tag;
import jovan.sf_62_2017.postsportal.pojo.User;
import jovan.sf_62_2017.postsportal.services.implementations.CommentsService;
import jovan.sf_62_2017.postsportal.services.implementations.PostsService;
import jovan.sf_62_2017.postsportal.services.implementations.TagService;
import jovan.sf_62_2017.postsportal.services.implementations.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PostsPortalApplication {

    public static void main(String[] args) {
        ApplicationContext acx = SpringApplication.run(PostsPortalApplication.class, args);

        UserService us = (UserService) acx.getBean("userService");
        PostsService ps = (PostsService) acx.getBean("postsService");
        CommentsService cs = (CommentsService) acx.getBean("commentsService");
        TagService ts = (TagService) acx.getBean("tagService");

        User user = new User();
        user.setUsername("username " + 0);
        user.setId(0);
        user.setName("Name " + 0);
        user.setPhotoUtl("URL" + 0);
        user.setPassword("password " + 0);

        us.add(user);
        User user2 = new User();
        user2.setUsername("username " + 0);
        user2.setId(1);
        user2.setName("Name " + 0);
        user2.setPhotoUtl("URL" + 0);
        user2.setPassword("password " + 0);
        us.add(user2);

        Tag tag = new Tag();
        tag.setId(0);
        tag.setName("Tag");
        List<Tag> tags = new ArrayList<>();
        tags.add(tag);


        Post p1 = new Post(0, "a", "a", "a", user, new Date(),
                5, 5, 5, 5);
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(p1);
        tag.setPosts(posts);

        ts.add(tag);

    }
}
