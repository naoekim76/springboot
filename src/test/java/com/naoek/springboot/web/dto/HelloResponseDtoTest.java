package com.naoek.springboot.web.dto;

import org.junit.Test;
/*
 * Junit의 기본 assertThat아 아닌 assertj의 assertThat을 사용시 장점
 *  - CoreMatchers와 달리 추가적으로 라이브러리가 필요하지 않음.
 *    (Junit의 asserThat을 쓰게 되면 is()와 같이 CoreMatchers 라이브러리가 필요함.
 *  - 자동완성이 좀 더 확실하게 지원됨.
 *    (IDE에서는 CoreMathers와 같은 Matcher 라이브러의 자동완성 지원이 약함)
 */
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void testLombok() {
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        /*
         * 1. assertThat
         *  - assertj라는 테스트 검증 라이브러리의 검증 메소드입니다.
         *  - 검증하고 싶은 대상을 메소드 인자로 받습니다.
         *  - 메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용할 수 있습니다.
         *
         * 2. isEqualTo
         *  - assertj의 동긍 비교 메소드입니다.
         *  - assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공입니다.
         */
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
