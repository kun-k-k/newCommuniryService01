package com.example.newCommuniryService01.Domain;

import com.example.newCommuniryService01.Dto.CommentDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDomain {

    Long id;
    Long postId;
    Long userId;

    String author;

    String content;

    public CommentDomain(
            Long id,
            Long postId,
            Long userId,
            String author,
            String content
    ){

        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.author = author;
        this.content= content;

    }

    public CommentDto toDto(){
        CommentDto commentDto
                = new CommentDto(
                id,
                postId,
                userId,
                author,
                content
        );
        return commentDto;
    }


}
