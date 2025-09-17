package com.example.demo.domain.dto;


import com.example.demo.domain.entity.Memo;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemoDto {

	@NotBlank(message="메모를 입력하세요")
	private String text;
	@NotBlank(message="메모를 입력하세요")
	@Email(message="example@example.com에 맞게 입력해주세요")
	private String writer;

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
        return new MemoDto(
                memo.getText(),
                null
        );
    }

}
