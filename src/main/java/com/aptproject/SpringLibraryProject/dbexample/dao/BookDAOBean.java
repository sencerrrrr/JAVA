package com.aptproject.SpringLibraryProject.dbexample.dao;


import com.aptproject.SpringLibraryProject.dbexample.model.Book;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookDAOBean {

    private final Connection connection;

    private final String BOOK_SELECT_BY_ID_QUERY = "select * from books where id = ?";

    public BookDAOBean(Connection connection) {
        this.connection = connection;
    }

    public Book findBookById(Integer bookId) throws  SQLException {

        PreparedStatement selectQuery = connection.prepareStatement(BOOK_SELECT_BY_ID_QUERY);
        selectQuery.setInt(1,bookId);
        ResultSet resultSet = selectQuery.executeQuery();
        Book book = new Book();
        while (resultSet.next()) {
            book.setId(resultSet.getInt("id"));
            book.setAuthor(resultSet.getString("author"));
            book.setTitle(resultSet.getString("title"));
            book.setDate_added(resultSet.getDate("date_added"));
            System.out.println(book);
        }
        return book;
    }
}





































