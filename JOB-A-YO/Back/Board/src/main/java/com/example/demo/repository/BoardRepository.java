package com.example.demo.repository;

import com.example.demo.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// Entity 클래스만 받음
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
