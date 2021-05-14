package com.naoek.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * - JpaRepository를 상속하면 기본적인 CRUD 메소드가 자동으로 생성됨.
 * - Entity 클래스와 Entity Repository는 같은 위치에 있어야 함.
 * - Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수 없음.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
