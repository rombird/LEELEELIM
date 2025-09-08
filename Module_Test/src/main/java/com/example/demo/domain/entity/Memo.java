package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity // JPA를 사용해 테이블과 매핑할 클래스에 붙여주는 어노테이션
@Table(name="memo")     // 생성할 Table 이름은 memo
@Data   // Lombok 관련 어노테이션
        // getter/setter, toString(), equals(),hashCode(), @RequireArgsConstructor같은 거 생성해줌
@NoArgsConstructor  // 매개변수 없는 기본 생성자를 만들어줌
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자 만들어줌
@Builder // 빌더 패턴을 자동으로 만들어줌
public class Memo {
    @Id // 이 필드를 테이블의 기본 키(Primary key)로 사용하겠다는 뜻
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // ID 값을 자동으로 생성해줌
    @Column(length = 1024)  // 크기가 1024까지
    private String text;
    @Column(length = 100, nullable = false) // 크기가 100까지 비우기 안됨
    private String writer;

    private LocalDateTime createAt;
}
