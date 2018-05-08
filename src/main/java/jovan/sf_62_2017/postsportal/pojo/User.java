package jovan.sf_62_2017.postsportal.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    private int id;
    private String name;
    private String photoUtl;
    private String username;
    private String password;
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Post> posts;
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Comment> comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUtl() {
        return photoUtl;
    }

    public void setPhotoUtl(String photoUtl) {
        this.photoUtl = photoUtl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Integer> getPostIDs() {
        List<Integer> ids = new ArrayList<Integer>();
        for (Post post: posts) {
            ids.add(post.getId());
        }
        return ids;
    }

    public List<Integer> getCommetIDs() {
        List<Integer> ids = new ArrayList<Integer>();
        for (Comment comment: comments) {
            ids.add(comment.getId());
        }
        return ids;
    }
}
