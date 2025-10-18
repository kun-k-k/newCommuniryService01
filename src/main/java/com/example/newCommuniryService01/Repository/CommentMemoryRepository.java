package com.example.newCommuniryService01.Repository;

import com.example.newCommuniryService01.Domain.CommentDomain;
import com.example.newCommuniryService01.Domain.PostDomain;
import com.example.newCommuniryService01.Dto.CommentDto;
import com.example.newCommuniryService01.Dto.PostDto;
import com.example.newCommuniryService01.Dto.CommentDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentMemoryRepository implements CommentRepository{


    private static Map<Long, CommentDomain> dbMap = new HashMap<>();
    private static Long sequence = 0L;




    // 상세조회 - 댓글 리스트 반환 (메서드 명 getCommentList로 변경하기)
        //-> findAll 메서드로 변경하기
    public List<CommentDto> listingComment(Long postId){

        List<CommentDto> commentDtoList = new ArrayList<>();

        for(CommentDomain commentDomain : dbMap.values()){
            if(commentDomain.getPostId().equals(postId)){
                /*회고: 도메인 객체 조회 시의 필터링 로직을 리포지토리 계층에서 침범해도 되는가 (코드 중복 줄이기 위해서)
                    => 해결: 리포 역할상 '데이터 전체' 전달만 하고 [리스트화, 필터링 로직]은 서비스에서 한꺼번에 수행
                 */

                CommentDto commentDto = commentDomain.toDto();
                commentDtoList.add(commentDto);
            }
        }

        return commentDtoList;
    }





    @Override
    public CommentDto save(CommentDomain commentDomain, Long postId) {

        commentDomain.setId(++sequence);
        commentDomain.setPostId(postId);
        dbMap.put(commentDomain.getId(), commentDomain);

        return null;

    }




    //commentId로 userId 가져오기
    public Long getUserId(Long commentId){

        CommentDomain commentDomain = dbMap.get(commentId);

        return commentDomain.getUserId();
    }



    @Override
    public CommentDomain findById(Long commentId) {

        return dbMap.get(commentId);

    }



    @Override
    public CommentDto update(CommentDomain commentDomain, Long commentId) {

        dbMap.put(commentId, commentDomain);

        return null;
    }



    @Override
    public CommentDto delete(Long commentId) {
        dbMap.remove(commentId);
        return null;
    }












    //폐기처분
    @Override
    public Map<Long, CommentDomain> viewPosts(String page, Long size) {

        return this.dbMap;
    }


}


