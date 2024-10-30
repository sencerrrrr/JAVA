package com.aptproject.SpringLibraryProject.library.service;

import com.aptproject.SpringLibraryProject.library.dto.BookDTO;
import com.aptproject.SpringLibraryProject.library.mapper.BookMapper;
import com.aptproject.SpringLibraryProject.library.model.Author;
import com.aptproject.SpringLibraryProject.library.model.Book;
import com.aptproject.SpringLibraryProject.library.repository.AuthorRepository;
import com.aptproject.SpringLibraryProject.library.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class BookService
        extends GenericService<Book, BookDTO>{
    private final AuthorRepository authorRepository;

    protected BookService(BookRepository repository,
                          BookMapper mapper,
                          AuthorRepository authorRepository) {
        super(repository, mapper);
        this.authorRepository = authorRepository;
    }

    public BookDTO addAuthor(final Long bookId,
                             final Long authorId) {
        BookDTO book = getOne(bookId);
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new NotFoundException("Автор не найден"));
        book.getAuthorIds().add(author.getId());
        update(book);
        return book;
    }
}
