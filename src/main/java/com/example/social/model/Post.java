package com.example.social.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    private String id;
    private String username;
    private String imgUrl;
    private String caption;
    private List<Comment> comments;
    private Date date;
}
