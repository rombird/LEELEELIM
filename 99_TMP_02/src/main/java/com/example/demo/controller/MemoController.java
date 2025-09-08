package com.example.demo.controller;


import com.example.demo.domain.dto.MemoDto;
import com.example.demo.domain.service.MemoService;
import com.example.demo.domain.service.MemoServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {

    @Autowired
    private MemoServiceImpl memoService;

	@GetMapping("/add")
	public void add_get() {
		log.info("GET /memo/add...");
	}

	@PostMapping("/add")
	public String add_post(@Valid MemoDto dto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) throws Exception{
		log.info("POST /memo/add...");
		
        //01 파라미터 받기(MemoDto)
        //02 유효성 검증(BindingResult)
        //- 유효성 검증 오류 발생시 -> memo/add 이동(오류필트메시지 전달)
        log.info("유효성 오류 발생 여부 : " + bindingResult.hasErrors());
        if(bindingResult.hasErrors()){ // 필드 에러가 있다면 에러를 하나씩 읽으면서
            for(FieldError error : bindingResult.getFieldErrors()){
                log.info("Error Field : " + error.getField() + "Error Message : " + error.getDefaultMessage());
                model.addAttribute(error.getField(), error.getDefaultMessage()); // 모델에 저장
            }
            return "memo/add"; // 반복작업이 끝나면 memo/add로
        }

        //03 서비스 실행(memoService(dto) 전달 후 memoId값 반환)
        Long memoId =  memoService.addMemoTx(dto); // MemoService파일에서 트랜잭션 설장한 addMemoTx와  연결
        if(memoId!=null)
            redirectAttributes.addFlashAttribute("result", "메모저장 성공 ID : " + memoId);
        //04 뷰로 이동 Redirect:/ , 리다이렉트 메시지 전달
        return memoId!=null ? "Redirect:/" : "memo/add";
	}

}


