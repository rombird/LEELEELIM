package com.example.demo.domain.entity;

import jakarta.persistence.*; //JPA 관련 어노테이션 import
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity //JPA ENTITY 명시, DB 테이블과 매핑
@Table(name="memo") //DB 내 테이블 이름을 "memo"로 지정
@Data //Lombok Annotation, getter/setter, toString등을 자동 생성
@NoArgsConstructor  //디폴트 생성자(Lombok)
@AllArgsConstructor //모든 아규먼트를 받는 생성자(Lombok)
@Builder    //빌더 패턴(Lombok)
public class Memo {
    //pk 지정을 위한 annotation
    @Id
    //ID값을 직접 입력할 필요 없이 알아서 내부적으로 Insert요청을 하면 자동으로 생성해줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    //id, text, createAt이라는 이름을 지니는 컬럼 생성
    private Long id;            //ID(기본키)
    private String text;        //내용
    private String writer;      //작성자
    private LocalDateTime createAt; //만들어진 시간
}
