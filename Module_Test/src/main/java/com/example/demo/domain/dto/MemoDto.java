package com.example.demo.domain.dto;


import com.example.demo.domain.entity.Memo;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data   // Lombok관련 어노테이션
@NoArgsConstructor  // 기본생성자
@AllArgsConstructor // 모든인자 생성자
public class MemoDto {

	@NotBlank(message="메모를 입력하세요")  // text에 들어온게 없다면 메모를 입력하세요
	private String text;
	@NotBlank(message="작성자를 입력하세요")  // writer에 들어온게 없다면 작성자를 입력하세요
	@Email(message="example@example.com에 맞게 입력해주세요")    // EMAIL양식에 맞게 작성해주세요
	private String writer;


    // Entity는 DB관련 작업, DTO는 클라이언트 관련 작업을 하기위해서 왔다갔다 시킴
    // DTO -> Entity 변환
    public Memo toEntity() {
        return Memo.builder()
                .text(this.text)
                .createAt(LocalDateTime.now())
                .build();
    }
    // Entity -> DTO 변환
    public static MemoDto fromEntity(Memo memo) {
        if (memo == null) return null;
        return new MemoDto(memo.getText(), null);
    }

}
