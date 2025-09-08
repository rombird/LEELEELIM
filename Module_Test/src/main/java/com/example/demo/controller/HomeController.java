package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 브라우저에서 오는 요청을 처리하는 Controller
@Slf4j      // log.info같은 거 보게해줌
public class HomeController {

    @GetMapping(value = "/")    // 아무것도 안 붙힌 주소상태
                                // ex: http://naver.com
    public String home(){

        log.info("GET /");
        return "index";         // index반환하니까 index페이지로 이동함
    }
}
