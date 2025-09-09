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

@Controller // 이 클래스 안의 메서드들은 요청을 처리하는 컨트롤러 메서드다 선언
@Slf4j      // 로깅
@RequestMapping("/memo")
public class MemoController {

    @Autowired
    private MemoService memoService;

	@GetMapping("/add")
    // 스프링의 뷰 이름 추론 규칙
    // 반환값이 void면 컨트롤러가 갖고있는 뷰졸러가 자동으로 GetMapping에 써있는 이름의 뷰로 가게 해줌
	public void add_get() {
		log.info("GET /memo/add...");
	}

    @GetMapping("/success")     // redirect로 success 페이지에 갈 때 보내줄 메서드
                                // redirect는 뷰를 찾는게 아닌 브라우저에서 요청을 다시 보내라고 지시하기 때문에
                                // 뷰졸러 안들고 있음. 그러니까 주소값을 반환해주어야함
    public String success_get() {
        log.info("GET /memo/success...");
        return "memo/success";
    }

	@PostMapping("/add")    // 사용자가 add에서 무언가를 작성하고 제출 -> /memo/add POST 요청
	public String add_post( // MemoDto 폼데이터 자동바인딩
                            // BindingResult 유효성 검증 결과
                            // Model 오류 메시지나 데이터 전달용
                            // RedirectAttributes redirect시 flash 메시지 전달용
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
//            return "except/error";
              return "memo/add";
        }


        //03 서비스 실행(memoService(dto) 전달 후 memoId값 반환)
        Long memoId =  memoService.addMemoTx(dto);      // MemoserviceImpl에서 만들어놓은거. 저장된 ID를 반환함
                                                        // MemoService가 Interface,
                                                        // 위에서 의존주입(AutoWired)됬기 때문에 사용가능

        if(memoId != null)
        //04 뷰로 이동 Redirect:/ , 리다이렉트 메시지 전달
            // 리다이렉트 요청함 result에 담긴 메시지와 저장된 Id를 갖고
         redirectAttributes.addFlashAttribute("result","메모저장 성공 ID : " + memoId);

        // @PostMapping되어있는 add_post의 반환값
        // 담긴 아이디가 있다면(전송 성공했다면) success페이지로 없다면 add 페이지로
        return memoId!=null ? "redirect:/memo/success" : "memo/add";
        // model.addAttribute("message", "메모등록완료" + memoId);
        // return "memo/success";
	}

}


