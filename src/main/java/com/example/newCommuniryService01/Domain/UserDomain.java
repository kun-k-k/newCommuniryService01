package com.example.newCommuniryService01.Domain;

import com.example.newCommuniryService01.Dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDomain {


    private Long id = 0L;
    private String userName;
    private String email;
    private String passWord;


    public UserDomain(String userName, String email, String passWord){
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;
    }



    //Domain - Dto 변환
    /*
    toDto 전용 클래스 -> toDto작업 추상화 가능? (user,post,comment 객체들)
     */
    public UserDto toDto() {
        return new UserDto(
                this.userName,
                this.email,
                null
        );
    }





    @Override
    public String toString() {
        return "UserDomain{userName='" + userName + "', email='" + email + "'}";

    }

}
