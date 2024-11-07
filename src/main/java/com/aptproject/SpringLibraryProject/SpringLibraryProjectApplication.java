package com.aptproject.SpringLibraryProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

//http://localhost:8080/swagger-ui/index.html
@SpringBootApplication
public class SpringLibraryProjectApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(SpringLibraryProjectApplication.class, args);
	}
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Override
	public void run(String... args) throws Exception{
	}
}