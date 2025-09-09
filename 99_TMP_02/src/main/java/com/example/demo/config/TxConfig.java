package com.example.demo.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.sql.DataSource;

@Configuration // @Bean 정의된 클래스에서 사용하는 Annotation
public class TxConfig {

    @Autowired // 의존성 객체 주입받기 위해 사용하는 Annotation
    private DataSource dataSource;

    @Bean(name="jpaTransactionManager") // 빈생성(트랜잭션을 위한 bean의 이름)
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
                            // JpaConfig에서 만들어진 entityManagerFactory를 의존 주입 - JPA를 사용하기 위해
                            // JpaTransactionManager 생성, DB작업을 하나의 트랜잭션 단위로 묶음
        //트랜잭션 기본 코드 작성
        JpaTransactionManager transactionManager = new JpaTransactionManager(); // 트랜잭션 매니저 객체 생성
        transactionManager.setEntityManagerFactory(entityManagerFactory); // 트랜잭션 매니저 EntityManagerFactory 인스턴스 참조하여 JPA 관련 트랜 잭션 처리
        transactionManager.setDataSource(dataSource); // dataSource 참조
        return transactionManager;
    }

}

