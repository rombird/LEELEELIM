package com.example.demo.entity;

import com.example.demo.dto.BoardDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Board DB의 테이블 역할을 하는 클래스
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "board_table")
public class BoardEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 ID 생성
    private Long id;

    @Column(nullable = false)
    private String boardTitle;

    @Column(nullable = false, length = 500)
    private String boardContents;

    @Column
    private int boardHits;

    public static BoardEntity toSaveEntity(BoardDto boardDto){
        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setBoardHits(0);
        boardEntity.setBoardTitle(boardDto.getBoardTitle());
        boardEntity.setBoardContents(boardDto.getBoardContents());

        return boardEntity;
    }
}
