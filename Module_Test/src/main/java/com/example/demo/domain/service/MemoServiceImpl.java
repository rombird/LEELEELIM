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

@Service    // 이 클래스는 이제부터 서비스 계층
            // 스프링이 자동으로 Bean으로 등록해서 관리
@Slf4j      // loggin 쓸 수 있게 해 줌
public class MemoServiceImpl implements MemoService {
    //JPA REPOSITORY
    @Autowired // 객체 주입
    private MemoRepository memoRepository;

    //트랜잭션 설정할 것
    // @Transactional 이 밑의 메서드에서 일어나는 DB작업은 하나의 트랜잭션
    // rollbackFor = SQLException.class -> SQL 관련 오류가 나면 롤백
    @Transactional(rollbackFor = SQLException.class, transactionManager = "jpaTransactionManager")
    @Override
    public Long addMemoTx(MemoDto dto) throws Exception{
        log.info("MemoService's addMemoTx2 Call!");
        //코드 완성
        // Dto의 값을 Entity(DB 저장/ 작업용)로 바꾸는 작업
        Memo memo = Memo.builder()
                        .id(null)
                .text(dto.getText())
                .writer(dto.getWriter())
                .createAt(LocalDateTime.now())
                .build();
        memoRepository.save(memo);  // memo에 담긴것들 저장
                                    // memoRepository는 JpaRepository를 상속받았기때문에
                                    // DB에 CRUD 가능
        return memo.getId();
    }
}