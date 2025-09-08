package com.example.demo.domain.service;

import com.example.demo.domain.dto.MemoDto;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

public interface MemoService {
    @Transactional(rollbackFor = SQLException.class, transactionManager = "jpaTransactionManager")
    Long addMemoTx(MemoDto dto) throws Exception;
}
