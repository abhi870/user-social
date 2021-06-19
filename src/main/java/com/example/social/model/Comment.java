package com.example.social.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    private String parentPostId;
    private String commentOwner;
    private String commentId;
    private String comment;
    private Date date;
}
