package com.example.demo.controller;


import com.example.demo.domain.dto.MemoDto;
import com.example.demo.domain.service.MemoService;
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
    private MemoService memoService;

	@GetMapping("/add")
	public void add_get() {
		log.info("GET /memo/add...");
	}

	@PostMapping("/add")
	public String add_post(
            @Valid MemoDto dto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes)
            throws Exception{
		log.info("POST /memo/add..." + dto);
		
        //01 파라미터 받기(MemoDto)   // ->add_post()안에 MemoDto dto가 파라미터
        //02 유효성 검증(BindingResult)
        if (bindingResult.hasErrors()){
            for(FieldError error : bindingResult.getFieldErrors()){
                log.info("Error Field: " + error.getField() + "Error Message: " + error.getDefaultMessage());
                    model.addAttribute(error.getField(), error.getDefaultMessage());
            }
            //- 유효성 검증 오류 발생시 -> memo/add 이동(오류필트메시지 전달)
            return "memo/add";
        }


        //03 서비스 실행(memoService(dto) 전달 후 memoId값 반환)
        Long memoId =  memoService.addMemoTx(dto);

        if(memoId != null)
            redirectAttributes.addFlashAttribute("message", "메모등록완료" + memoId);
        //04 뷰로 이동 Redirect:/ , 리다이렉트 메시지 전달
        //redirectAttributes.addFlashAttribute("result","메모저장 성공 ID : " + memoId);
        return memoId!=null ? "redirect:/" : "memo/add";
	}

}


