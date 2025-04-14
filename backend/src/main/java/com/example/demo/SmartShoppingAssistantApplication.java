package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Value;

import javax.sql.DataSource;

/**
 * Main application class for the Smart Shopping Assistant backend.
 * Class configures the application's data source depending on
 * the environment (real or mock) and starts the Spring Boot application.
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SmartShoppingAssistantApplication {

	/**
	 * Entry point of the Spring Boot application
	 */
	public static void main(String[] args) {
		SpringApplication.run(SmartShoppingAssistantApplication.class, args);
	}

	/**
	 * Defines the DataSource bean to be used throughout the application.
	 * Will either be the mock database or a local SQL database depending on
	 * the database.type variable defined in application.properties.
	 * 
	 * @param databaseType The type of database to use ("real" or "mock")
	 * @return configured DataSource instance
	 */
	@Bean
	public DataSource dataSource(@Value("${database.type}") String databaseType) {
		if ("real".equals(databaseType)) {
			System.out.println("Using local SQL database");
			return getSqlSource();
		} else {
			System.out.println("Using mock database");
			return getH2Source();
		}
	}

	/**
	 * Returns a DataSource configured for a real local SQL server
	 */
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

	/**
	 * Returns a DataSource configured for the mock H2 database
	 */
	private DataSource getH2Source() {

		// Instance of DriverManagerDataSource
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
		// Use in-memory H2 database
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:./src/test/resources/data/testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        return dataSource;
	}


	/**
	 * Defines a JdbcTemplate bean for SQL database interaction
	 * 
	 * @param dataSource The configured data source (real or mock)
	 * @return	JdbcTemplate instance
	 */
	@Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
