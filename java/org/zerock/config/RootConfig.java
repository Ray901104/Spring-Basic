package org.zerock.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"org.zerock.service"})
@MapperScan(basePackages = {"org.zerock.mapper"})
public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
		HikariConfig hc = new HikariConfig();
		hc.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hc.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:xe");
		
		hc.setUsername("book_ex");
		hc.setPassword("book_ex");
		
		HikariDataSource hds = new HikariDataSource(hc);
		
		return hds;
	}//dataSource
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setDataSource(dataSource());
		
		return (SqlSessionFactory) ssfb.getObject();
	}//sqlSessionFactory

}//class
