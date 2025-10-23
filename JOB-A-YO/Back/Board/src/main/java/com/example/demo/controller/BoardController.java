package com.example.demo.controller;

import com.example.demo.dto.BoardDto;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("")
    public String board(){
        log.info("GET / board 게시판");
        return "board";
    }

    @GetMapping("/boardWrite")
    public String writeForm(){
        log.info("Get/ boardWrite 게시판 글쓰기");

        return"boardWrite";

    }

    @PostMapping("/boardWrite")
    public String write(@ModelAttribute BoardDto boardDto){
        System.out.println("boardDto:" +boardDto);
        boardService.save(boardDto);

        return "board";
    }

}
