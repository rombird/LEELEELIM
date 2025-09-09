//package com.example.demo.config;
//
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.jpa.JpaTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class TxConfigMy {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean(name="jpaTransactionManager") // 트랜잭션을 위한 빈의 이름
//    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
//        //트랜잭션 기본 코드 작성
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        transactionManager.setDataSource(dataSource);
//        return transactionManager;
//    }
//
//}
//
