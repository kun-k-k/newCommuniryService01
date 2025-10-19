package com.example.newCommuniryService01.Strategy.Policy;

import com.example.newCommuniryService01.Dto.PostDto;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class PostAdminOnlyPolicy implements PostPolicy{


    public Boolean matchStrategy(Long sessionUserId){

        return false;
    }


    public PostDto updatePost(PostDto postDto){



        return null;
    }

}
