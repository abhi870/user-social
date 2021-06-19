package com.example.social.service;

import com.example.social.dto.CommentDto;
import com.example.social.dto.PostDto;
import com.example.social.exceptions.UserDoesNotExistsException;
import com.example.social.model.AppUser;
import com.example.social.model.Post;
import com.example.social.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import static com.example.social.constants.ExceptionConstants.USER_DOES_NOT_EXISTS;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<PostDto> getFeedForUser(String username) {
        List<PostDto> feedElementList = new LinkedList<>();
        userRepository.getByid(username).getFeedPosts()
                .forEach(p -> feedElementList.add(new PostDto(p.getUsername(), p.getImgUrl(), p.getCaption()
                        , getComments(p), p.getDate())));
        return null;
    }

    @Override
    public boolean followUser(String currentUser, String toBeFollowed) {
        AppUser userToBeFollowed = userRepository.getByid(toBeFollowed);
        userRepository.getByid(currentUser).followOtherUser(userToBeFollowed);
        return true;
    }

    @Override
    public List<PostDto> getProfileFeed(String username) {
        List<PostDto> posts = new LinkedList<>();
        AppUser currentUser = userRepository.getByid(username);
        if (currentUser == null)
            throw new UserDoesNotExistsException(USER_DOES_NOT_EXISTS);
        currentUser.getPosts().stream().forEach(p -> posts.add(mapPostToPostDto(p)));
        return posts;
    }

    private List<CommentDto> getComments(Post p) {
        List<CommentDto> comments = new LinkedList<>();
        p.getComments()
                .stream()
                .forEach(c -> comments.add(new CommentDto(c.getCommentOwner(), c.getComment(), c.getDate())));
        return comments;
    }

    private PostDto mapPostToPostDto(Post p) {
        return new PostDto(p.getUsername(), p.getImgUrl(), p.getCaption(), getComments(p), p.getDate());
    }
}
