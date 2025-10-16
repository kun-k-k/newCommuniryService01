package com.example.newCommuniryService01.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {


    private String message = "";

    private DataDto data;


    public ResponseDto(PostPageDto data) {
        this.data = data;
        //this.message = message;
    }

    public ResponseDto(PostListDto data) {
        this.data = data;
        //this.message = message;
    }
    public ResponseDto(String message) {
        this.message = message;
    }




}
