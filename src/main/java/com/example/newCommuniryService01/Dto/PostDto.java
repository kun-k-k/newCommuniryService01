package com.example.newCommuniryService01.Dto;

import com.example.newCommuniryService01.Domain.PostDomain;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PostDto {


    private Long id = 0L;
    private Long userId = 0L;
    private String author = "";

    private String title = "";
    private String content = "";


    public PostDto(
            Long id,
            Long userId,
            String author,
            String title,
            String content
    ){

        this.id = id;
        this.userId = userId;
        this.author = author;
        this.title = title;
        this.content = content;

    }

    public PostDomain toDomain(){

        PostDomain postDomain
                = new PostDomain(
                id,
                userId,
                author,
                title,
                content
        );
        return postDomain;
    }


}
