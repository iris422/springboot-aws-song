package com.book.song.domain.posts;

import com.book.song.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor   // 기본 생성자 자동 추가
@Entity    // 테이블과 링크될 클래스임을 표시, Entity 클래스는 NEVER(!!!) Setter 메소드를 만들지 않음 (DB 연결되니 당연!!!)
public class Posts extends BaseTimeEntity {

    @Id    // PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // PK 생성 규칙, GenerationType.IDENTITY 옵션 추가해야 auto_increment 가능
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
