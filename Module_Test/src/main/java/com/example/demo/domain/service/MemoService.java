package com.example.demo.domain.service;

import com.example.demo.domain.dto.MemoDto;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

// 비즈니스
public interface MemoService {
    // addMemoTx를 하나의 트랜잭션으로 설정
    // 모두 성공하면 commit, SQLException관련 에러 발생하면 rollback
    // 사용할 트랜잭션 매니저 지정
    @Transactional(rollbackFor = SQLException.class, transactionManager = "jpaTransactionManager")
    Long addMemoTx(MemoDto dto) throws Exception;      // 추상 메서드 addMemoTx던짐
                                                        // MemoServiceImpl가 구현함
}
