package com.naoek.springboot.service;

import com.naoek.springboot.domain.posts.Posts;
import com.naoek.springboot.domain.posts.PostsRepository;
import com.naoek.springboot.web.dto.PostsResponseDto;
import com.naoek.springboot.web.dto.PostsSaveRequestDto;
import com.naoek.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new PostsResponseDto(entity);
    }
}
