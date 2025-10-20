package com.example.newCommuniryService01.Strategy.Policy;

import com.example.newCommuniryService01.Dto.PostDto;
import com.example.newCommuniryService01.Dto.PostListDto;
import com.example.newCommuniryService01.Dto.PostPageDto;
import org.springframework.stereotype.Component;

@Component
public interface PostPolicy {


    public Boolean matchStrategy(Long sessionUserId);



    //추가
    public PostDto createPost(PostDto postDto, Long sessionUserId);

    //전체 조회, 상세 조회
    public PostListDto viewPosts(String page, Long size);
    public PostPageDto viewOnePost(Long postId, Long sessionUserId);

    //수정, 삭제
    public Boolean updatePost(PostDto postDto, Long postId, Long sessionUserId);
    public Boolean deletePost(Long postId, Long sessionUserId);







    /*


    (CRUD)

    | 게시글 create 분기
    1) 관리자에게만 보이게
    2) 로그인한 유저에게만 보이게
    3) 모두에게 보이게

    | 게시글 update 분기
    1) 관리자에게만
    2) 로그인한 유저에게만 보이게
    3) 모두에게 보이게


    ---


    | 유저별 정책 구분
    1) 일반유저
    2) 관리자
    3) 로그아웃 유저



    | 리소스별 정책 구분
    1) 일반유저만
    2) 관리자만
    3) 일반유저 + 관리자만
    4) 모두 가능
    5) 시크릿모드



     */
}
