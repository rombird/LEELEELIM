package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Spring Data JPA를 쓸 때 필요함
            // Spring Data JPA를 더 쉽게 쓰게 해주는 Spring의 라이브러리
            // -> DB와 객체(Entity) 매핑을 자동으로 해주고, 반복적인 CRUD코드까지 작성해줌
public interface MemoRepository extends JpaRepository<Memo, Long> { // 제네릭 타입 파라미터를 받는 JpaRepository
                                                                        // 첫 번째 매개변수 -> Entity타입,
                                                                    // 두 번째 매개변수 -> Entity의 PK타입
    // JpaRepository를 상속받은 MemoRepository는 CRUD 기능 구현가능
}
