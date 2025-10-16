package com.example.newCommuniryService01.Service;


import com.example.newCommuniryService01.Domain.CommentDomain;
import com.example.newCommuniryService01.Dto.CommentDto;
import com.example.newCommuniryService01.Dto.UserDto;
import com.example.newCommuniryService01.Repository.CommentRepository;
import com.example.newCommuniryService01.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    @Autowired
    CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }


    //댓글 - 추가
    public CommentDto createComment(CommentDto commentDto, Long postId, Long sessionUserId){


        //세션 매치해서 가져온 userId 할당
        commentDto.setUserId(sessionUserId);

        commentRepository.save(commentDto.toDomain(), postId);
        return null;
    }




    //댓글 - 수정
    public Boolean updateComment(CommentDto commentDto, Long postId, Long commentId, Long sessionUserId){



        //접근 권한 필터링
        if(!sessionUserId.equals(commentRepository.getUserId(commentId))){
            return true;
        }

        //코드 회고: Patch메서드인데 필드 값 전체를 변경하는 Put으로 구현함 -> 수정 마다 postId 재할당 해야됨
        commentDto.setPostId(postId);
        //
        commentDto.setId(commentId);
        commentDto.setUserId(commentRepository.findById(postId).getUserId());
        commentDto.setAuthor(commentRepository.findById(postId).getAuthor());
        //---
        commentRepository.update(commentDto.toDomain(), commentId);

        return false;
    }



    //댓글 - 삭제
    public Boolean deleteComment(Long postId, Long commentId, Long sessionUserId){


        //접근 권한 필터링
        if(!sessionUserId.equals(commentRepository.getUserId(commentId))){
            return true;
        }

        commentRepository.delete(commentId);

        return false;
    }







}
