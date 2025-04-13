package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Value;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import javax.sql.DataSource;

// Main application class
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SmartShoppingAssistantApplication {

	// Main method: Entry point of the Spring Boot application
	public static void main(String[] args) {
		SpringApplication.run(SmartShoppingAssistantApplication.class, args);
	}


	// Defining datasource bean to configure the connection to the SQL Server
	@Bean
	public DataSource dataSource(@Value("${database.type}") String databaseType) {
		if ("real".equals(databaseType)) {
			System.out.println("ITS REAL");
			return getSqlSource();
		} else {
			System.out.println("ITS A MOCK");
			return getH2Source();
		}
	}


	private DataSource getSqlSource() {
		// Instance of DriverManagerDataSource
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// Setting necessary database variables
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=SmartShoppingAssistantDB;trustServerCertificate=true;");
		dataSource.setUsername("collinstm");
		dataSource.setPassword("Triagan2010");

		return dataSource;
	}


	private DataSource getH2Source() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
		// Use in-memory H2 database
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:./src/test/resources/data/testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        return dataSource;
	}


	// Defining a jdbcTemplate bean to interact with the database using SQL
	@Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
