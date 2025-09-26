package com.example.demo.domain.service;

import com.example.demo.domain.dto.MemoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Memo {

    @Autowired
    private MemoServiceImpl txTestService;
    @Test
    void t2() throws Exception {
        txTestService.addMemoTx(new MemoDto(1,"TEST1"));
    }

}
