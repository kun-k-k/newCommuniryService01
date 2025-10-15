package com.example.newCommuniryService01.Repository;

import com.example.newCommuniryService01.Domain.UserDomain;
import com.example.newCommuniryService01.Dto.CommentDto;
import com.example.newCommuniryService01.Dto.PostDto;
import com.example.newCommuniryService01.Dto.UserDto;

public interface UserRepository {

    //회원가입
    public UserDomain save(UserDomain userDomian);

    //로그인
    public UserDomain findByEmail(String email);


    //id로 회원 조회
    public UserDomain findById(Long userId);


}
