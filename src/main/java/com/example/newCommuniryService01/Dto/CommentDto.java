package com.example.newCommuniryService01.Dto;


import com.example.newCommuniryService01.Domain.CommentDomain;
import com.example.newCommuniryService01.Domain.PostDomain;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

    Long id;
    Long postId;
    Long userId;

    String author;

    String content;



    public CommentDto(
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

    public CommentDomain toDomain(){
        CommentDomain commentDomain
                = new CommentDomain(
                id,
                postId,
                userId,
                author,
                content
        );
        return commentDomain;
    }


}
