package com.naoek.springboot.config.auth.dto;

import com.naoek.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/*
 * SessionUser에는 인증된 사용자 정보만 필요로 합니다.
 * 도메인 패키지에 있는 User 엔티티 객체를 사용하면 추후 타 엔티티 객체와 연관설정을 하게 될 경우 직렬화 성능 문제를 비롯해
 * 여러 문제를 야기시킬 수 있으므로 별도의 SessionUser 객체를 잉요하는 것임.
 */
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
