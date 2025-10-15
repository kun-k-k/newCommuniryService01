package com.example.newCommuniryService01.Repository;

import com.example.newCommuniryService01.Domain.CommentDomain;
import com.example.newCommuniryService01.Domain.PostDomain;
import com.example.newCommuniryService01.Dto.CommentDto;
import com.example.newCommuniryService01.Dto.PostDto;

import java.util.List;
import java.util.Map;

public interface CommentRepository {

    //게시글 전체조회
    public Map<Long, CommentDomain> viewPosts(String page, Long size);


    //게시글 상세조회
    public List<CommentDto> listingComment(Long postId);

    //댓글 추가
    public CommentDto save(CommentDomain commentDomain, Long postId);

    public Long getUserId(Long postId);

    public CommentDomain findById(Long id);


    //댓글 수정
    public CommentDto update(CommentDomain commentDomain, Long commentId);
    //댓글 삭제
    public CommentDto delete(Long commentId);




    /*

    게시글 추가 () / userId
    게시글 전체조회 ()

    게시글 상세조회 (postId)
        ㄴ댓글 조회 (postId)

    게시글 수정, 삭제 (postId) / userId
    댓글 추가, 수정, 삭제 (commentId) / userId


     */


}
