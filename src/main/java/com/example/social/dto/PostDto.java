package com.example.social.dto;

import com.example.social.model.Comment;
import com.example.social.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {
    private String username;
    private String imgUrl;
    private String caption;
    private List<CommentDto> comments;
    private Date date;
}
