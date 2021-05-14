package com.naoek.springboot.web;

import com.naoek.springboot.service.PostsService;
import com.naoek.springboot.web.dto.PostsResponseDto;
import com.naoek.springboot.web.dto.PostsSaveRequestDto;
import com.naoek.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    /*
     * @Autowired 대신 생성자 주입 방식을 사용함.
     * 생성자는 @RequiredArgsConstructor lombok 어노테이션에 의해 자동으로 생성됨 (final로 선언된 모든 필드를 인자값으로 생성됨)
     */
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
