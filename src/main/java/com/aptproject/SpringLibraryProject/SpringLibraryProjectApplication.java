package com.aptproject.SpringLibraryProject;
import com.aptproject.SpringLibraryProject.dbexample.dao.BookDAOBean;
import com.aptproject.SpringLibraryProject.dbexample.dao.BookDaoJDBC;
import com.aptproject.SpringLibraryProject.dbexample.db.DBConnection;
import com.aptproject.SpringLibraryProject.dbexample.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.awt.*;
import java.util.List;
//http://localhost:8080/swagger-ui/index.html
@SpringBootApplication
public class SpringLibraryProjectApplication implements CommandLineRunner {
//	private	BookDAOBean bookDAOBean;
//	public SpringLibraryProjectApplication(BookDAOBean bookDAOBean) {
//		this.bookDAOBean = bookDAOBean;
//	}
//	@Autowired
//	private NamedParameterJdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(SpringLibraryProjectApplication.class, args);
	}

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void run(String... args) throws Exception{
//		BookDaoJDBC bookDaoJDBC = new BookDaoJDBC();
//		bookDaoJDBC.findBookById(1);
//		BookDAOBean bookDAOBean = new BookDAOBean(DBConnection.INSTANCE.getConnection());
//		bookDAOBean.findBookById(4);
//		List<Book> bookList = jdbcTemplate.query("select * from books",
//				((rs, rowNum) -> new Book(
//						rs.getInt("id"),
//						rs.getString("title"),
//						rs.getString("author"),
//						rs.getDate("date_added")
//				)));
//		bookList.forEach(System.out::println);
	}
}