package com.example.newCommuniryService01.Domain;


import com.example.newCommuniryService01.Dto.PostDto;
import lombok.Getter;
import lombok.Setter;

import javax.swing.text.StyledEditorKit;

@Getter
@Setter
public class PostDomain {


    private Long id = 0L;
    private Long userId = 0L;
    private String author = "";

    private String title = "";
    private String content = "";

    //부여할 조회권한별 분기 필요 (관리자에게만, 로그인에게만, 모두에게, +나에게만)
    // (-> 일단 지금은 adminOnly으로만 분기, 열거형 필드로 수정 후 나중에 '로그인,모두,나에게' 등 추가하기)
    private Boolean adminOnly = false;



    public PostDomain(
            Long id,
            Long userId,
            String author,
            String title,
            String content,
            Boolean adminOnly
    ){

        this.id = id;
        this.userId = userId;
        this.author = author;
        this.title = title;
        this.content = content;
        this.adminOnly = adminOnly;

    }


    public PostDto toDto(){

        PostDto postDto
                = new PostDto(
                id,
                userId,
                author,
                title,
                content,
                adminOnly
        );
        return postDto;
    }


}
