package com.example.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

	@Bean // 리턴되는 객체를 IOC 컨테이너에 등록
	public HikariDataSource dataSource() // 객체를 설정
	{
        //HikariDataSource 사용할 것
        //Mysql Connection
        // Id : root
        // Pw : 1234
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testdb");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        return dataSource;
	}

}
