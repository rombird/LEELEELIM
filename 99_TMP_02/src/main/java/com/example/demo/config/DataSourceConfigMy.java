//package com.example.demo.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration // 여기서부터는 Bean 등록하는곳
//public class DataSourceConfigMy {
//
//	@Bean // 리턴되는 객체를 IOC 컨테이너에 등록
//	public HikariDataSource dataSource() // 객체를 설정
//	{
//        //HikariDataSource 사용할 것
//        //Mysql Connection
//        // Id : root
//        // Pw : 1234
//        HikariDataSource dataSource = new HikariDataSource(); // JDBC 접속 설정을 Hikari를 이용해서 dataSource 객체로 생성
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testdb"); // HikariDataSource 사용시 setJdbc를 사용
//        dataSource.setUsername("root"); // MySQL Username과 동일하게 설정
//        dataSource.setPassword("1234"); // MySQL Password와 동일하게 설정
//
//        return dataSource; // dataSource로 리턴지정!
//	}
//
//}
