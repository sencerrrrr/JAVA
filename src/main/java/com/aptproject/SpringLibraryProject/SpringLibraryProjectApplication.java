package com.aptproject.SpringLibraryProject;
import com.aptproject.SpringLibraryProject.dbexample.dao.BookDAOBean;
import com.aptproject.SpringLibraryProject.dbexample.dao.BookDaoJDBC;
import com.aptproject.SpringLibraryProject.dbexample.db.DBConnection;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLibraryProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringLibraryProjectApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
//		BookDaoJDBC bookDaoJDBC = new BookDaoJDBC();
//		bookDaoJDBC.findBookById(1);

		BookDAOBean bookDAOBean = new BookDAOBean(DBConnection.INSTANCE.getConnection());
		bookDAOBean.findBookById(4);
	}

}
