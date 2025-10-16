package com.example.newCommuniryService01.Controller;

import com.example.newCommuniryService01.Domain.UserDomain;
import com.example.newCommuniryService01.Dto.DataDto;
import com.example.newCommuniryService01.Dto.PostDto;
import com.example.newCommuniryService01.Dto.ResponseDto;
import com.example.newCommuniryService01.Dto.UserDto;
import com.example.newCommuniryService01.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {


    private UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }







    //유저 - 회원가입
    @PostMapping("/users")
    public ResponseDto signUp(@RequestBody UserDto userDto){


        //Dto 입력값 유효성검증
        userDto.validation();

        //Dto객체 전달
        UserDto userDtoSaved = userService.signUp(userDto);



        return new ResponseDto("post_success");

    }




    //유저 - 회원 탈퇴



    //유저 - 회원정보 조회
    //유저 - 회원정보 수정










}
