package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
//DB-Entity 매핑, CRUD코드 작성가능

public interface MemoRepository extends JpaRepository<Memo,Long> {
                                                    //<엔터티, 엔터티 pk 자료형(타입)>
                                        //JpaRepository<Memo,Long> : 기본 CRUD하는 함수들이 생성됨
//MemoRepository도 CRUD기능을 소유하게 됨
}

