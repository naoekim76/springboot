package com.naoek.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
 * @EnableJpaAuditing을 사용하기 위해선 최소 하나의 @Entity 클래스가 필요한데 @WebMvcTest에서는 @Entity 클래스가 없으니
 * 테스트 진행 시 에러가 발생함.
 * @SpringBootApplication과 함께 설정되어 있어 @WebMvcTest에서도 스캔되므로 @EnableJpaAuditing과 @SpringBootApplication 둘을 분리
 * @EnableJpaAuditing은 JpaConfig를 생성하여 추가
 */
//@EnableJpaAuditing // JPA Auditing 기능 활성화
/*
 * - @SpringBootApplication으로 인해 스프링 부트와 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정.
 * - @SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에 항상 프로젝트의 최 상단에 위치해야 함.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        /*
         * - SpringApplication.run으로 내장 WAS를 실행
         * - 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있기 때문에 내장 WAS를 사용하는 것을 권장
         */
        SpringApplication.run(Application.class, args);
    }
}