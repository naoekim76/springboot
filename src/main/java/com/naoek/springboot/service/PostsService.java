package com.naoek.springboot.service;

import com.naoek.springboot.domain.posts.Posts;
import com.naoek.springboot.domain.posts.PostsRepository;
import com.naoek.springboot.web.dto.PostsListResponseDto;
import com.naoek.springboot.web.dto.PostsResponseDto;
import com.naoek.springboot.web.dto.PostsSaveRequestDto;
import com.naoek.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {

    /*
     * @Autowired 대신 생성자 주입 방식을 사용함.
     * 생성자는 @RequiredArgsConstructor lombok 어노테이션에 의해 자동으로 생성됨 (final로 선언된 모든 필드를 인자값으로 생성됨)
     */
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

//    @Transactional
//    public Long update(Long id, PostsUpdateRequestDto requestDto) {
//        Optional<Posts> opts = postsRepository.findById(id);
//        Posts posts = null;
//
//        if (opts.isPresent()) {
//            posts = opts.get();
//            posts.update(requestDto.getTitle(), requestDto.getContents());
//        } else {
//            throw new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
//        }
//
//        return id;
//    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        /*
         * .map(PossListResponseDto::new)
         *  - postRepository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsListResponseDto 변환 -> List로 반환하는 메소드임.
         */
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        postsRepository.delete(posts);
    }
}