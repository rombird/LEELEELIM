package com.example.demo.domain.service;

import com.example.demo.domain.dto.MemoDto;
import com.example.demo.domain.entity.Memo;
import com.example.demo.domain.repository.MemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class MemoServiceImpl implements MemoService {
    //JPA REPOSITORY
    @Autowired
    private MemoRepository memoRepository;

    //트랜잭션 설정할 것
    @Transactional(rollbackFor = SQLException.class, transactionManager = "jpaTransactionManager") // TxConfig파일의 지정해놓은 빈의 이름과 일치!!
    @Override
    public Long addMemoTx(MemoDto dto) throws Exception{
        log.info("MemoService's addMemoTx2 Call!");
        //코드 완성
        // dto -> Entity(Memo)
        Memo memo = Memo.builder()
                .id(null)
                .text(dto.getText())
                .createAt(LocalDateTime.now())
                .build();
        memoRepository.save(memo); // 메모의 내용 추가하는 작업
        return memo.getId(); // 추가된 행의 id 값 반환받도록 설정
    }
}