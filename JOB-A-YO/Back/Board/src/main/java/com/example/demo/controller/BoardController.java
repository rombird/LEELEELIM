package com.example.demo.controller;

import com.example.demo.dto.BoardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/boardWrite")
    public String writeForm(){
        log.info("Get/ boardWrite");

        return"boardWrite";

    }

    @PostMapping("/boardWrite")
    public String save(@ModelAttribute BoardDto boardDto){


        return null;
    }

}
