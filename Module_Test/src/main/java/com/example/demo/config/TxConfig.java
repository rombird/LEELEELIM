package com.example.demo.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
public class TxConfig {

    @Autowired
    private DataSource dataSource;

    @Bean(name="jpaTransactionManager")
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
                            // JpaConfig에서 만들어진 entityManagerFactory를 의존 주입
                            // JpaTransactionManager 생성, DB작업을 하나의 트랜잭션 단위로 묶음
        //트랜잭션 기본 코드 작성
        JpaTransactionManager transactionManager = new JpaTransactionManager(); // 트랜잭션 매니저 객체 생성
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

}

