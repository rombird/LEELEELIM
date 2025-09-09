package com.example.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 여기서부터는 Bean 등록하는곳
public class DataSourceConfig {

	@Bean // dataSource가 return하는 건 스프링이 Bean으로 받아서 관리
	public HikariDataSource dataSource()
	{
        //HikariDataSource 사용할 것
        HikariDataSource dataSource = new HikariDataSource(); // JDBC 접속 설정을 Hikari를 이용해서 dataSource 객체로 생성
        //Mysql Connection
        //SQL데이터 베이스에 연결하기 위한 JDBC URL 설정
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testdb"); // HikariDataSource 사용시 setJdbc를 사용
        // Id : root
        dataSource.setUsername("root"); // MySQL Username과 동일하게 설정
        // Pw : 1234
        dataSource.setPassword("1234"); // MySQL Password와 동일하게 설정
        return dataSource;
	}

}
