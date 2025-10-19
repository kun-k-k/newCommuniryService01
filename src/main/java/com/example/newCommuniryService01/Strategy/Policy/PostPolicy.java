package com.example.newCommuniryService01.Strategy.Policy;

import com.example.newCommuniryService01.Dto.PostDto;

public interface PostPolicy {


    public PostDto updatePost(PostDto postDto);








    /*

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
