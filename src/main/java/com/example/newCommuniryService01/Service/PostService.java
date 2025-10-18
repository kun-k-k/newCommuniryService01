package com.example.newCommuniryService01.Service;


import com.example.newCommuniryService01.Domain.PostDomain;
import com.example.newCommuniryService01.Dto.CommentDto;
import com.example.newCommuniryService01.Dto.PostDto;
import com.example.newCommuniryService01.Dto.PostListDto;
import com.example.newCommuniryService01.Dto.PostPageDto;
import com.example.newCommuniryService01.Repository.CommentRepository;
import com.example.newCommuniryService01.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PostService {

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    @Autowired
    PostService(PostRepository postRepository, CommentRepository commentRepository){
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }






    //게시글 - 추가
    public PostDto createPost(PostDto postDto, Long sessionUserId){

        //세션 매치해서 가져온 userId 할당
        postDto.setUserId(sessionUserId);

        //정책 - 제목,내용은 필수입니다

        PostDomain postDomain = postDto.toDomain();
        return (postRepository.save(postDomain)).toDto();

    }



    //게시글 - 전체조회
    public PostListDto viewPosts(String page, Long size){

        Map<Long, PostDomain> postDbMap = postRepository.findAll(page, size);

        List<PostDto> postDtoList = new ArrayList<>();


        for (PostDomain postDomain : postDbMap.values()) {
            PostDto postDto = postDomain.toDto();
            postDtoList.add(postDto);
        }

        return new PostListDto(postDtoList);

    }


    //게시글 - 상세조회
    public PostPageDto viewOnePost(Long postId){


        //게시글 객체 겟
        PostDomain postDomain = postRepository.findById(postId);

        //댓글 리스트화 (postId)
        List<CommentDto> commentDomainList = commentRepository.listingComment(postId);

        //응답 Dto에 담기
        PostPageDto postPageDto = new PostPageDto();

        postPageDto.setPostDto(postDomain.toDto());
        postPageDto.setCommentDtoList(commentDomainList);


        return postPageDto;
    }


    //게시글 - 수정
    public Boolean updatePost(PostDto postDto, Long postId, Long sessionUserId){



        //접근 권한 필터링
        if(!sessionUserId.equals(postRepository.getUserId(postId))){
            return true;
        }

        //메인 수정작업 (-> 도메인과 Dto객체 내부 메서드 - PUT에서 PATCH로 수정 필요)
        postDto.setId(postId);
        postDto.setUserId(postRepository.findById(postId).getUserId());
        postDto.setAuthor(postRepository.findById(postId).getAuthor());
        //
        postRepository.update(postDto.toDomain(), postId);


        //PATCH화
        /*
        1) Dto객체(3상태) 겟 - 변경된 필드 파악
        2) 리포에서 도메인 객테 겟 - 세터로 일부 필드 셋 후 리포 저장

         */





        return false;


    }



    //게시글 - 삭제
    public Boolean deletePost(Long postId, Long sessionUserId){


        //접근 권한 필터링
        if(!sessionUserId.equals(postRepository.getUserId(postId))){
            return true;
        }

        //메인 삭제작업
        PostDomain postDomain = postRepository.delete(postId);

        return false;



    }





}
