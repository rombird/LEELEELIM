package com.example.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration  // 여기서부터는 Bean 등록하는곳
public class DataSourceConfig {

	@Bean // dataSource가 return하는 건 스프링이 Bean으로 받아서 관리해줄거임
	public HikariDataSource dataSource()
	{
        //HikariDataSource 사용할 것
        HikariDataSource dataSource = new HikariDataSource();
        //Mysql Connection
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testdb");
        // Id : root
        dataSource.setUsername("root");
        // Pw : 1234
        dataSource.setPassword("1234");
        return dataSource;
	}

}
