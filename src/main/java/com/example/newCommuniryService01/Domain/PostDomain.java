package com.example.newCommuniryService01.Domain;


import com.example.newCommuniryService01.Dto.PostDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDomain {


    private Long id = 0L;
    private Long userId = 0L;
    private String author = "";

    private String title = "";
    private String content = "";




    public PostDomain(
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


    public PostDto toDto(){

        PostDto postDto
                = new PostDto(
                id,
                userId,
                author,
                title,
                content
        );
        return postDto;
    }


}
