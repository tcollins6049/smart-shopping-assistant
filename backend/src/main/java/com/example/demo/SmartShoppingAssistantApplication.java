package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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
	public DataSource dataSource() {
		// Instance of DriverManagerDataSource
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// Setting necessary database variables
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=SmartShoppingAssistantDB;trustServerCertificate=true;");
		dataSource.setUsername("collinstm");
		dataSource.setPassword("Triagan2010");

		System.out.println("DataSource bean created");

		// Return configured datasource instance
		return dataSource;
	}


	// Defining a jdbcTemplate bean to interact with the database using SQL
	@Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
