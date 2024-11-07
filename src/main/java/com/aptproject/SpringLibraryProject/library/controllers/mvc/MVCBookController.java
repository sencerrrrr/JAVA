package com.aptproject.SpringLibraryProject.library.controllers.mvc;

import com.aptproject.SpringLibraryProject.library.dto.BookDTO;
import com.aptproject.SpringLibraryProject.library.service.BookService;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/books")
public class MVCBookController {

    private static final Logger log = LoggerFactory.getLogger(MVCBookController.class);
    private final BookService bookService;

    public MVCBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<BookDTO> books = bookService.listAll();
        model.addAttribute("books", books);
        return "books/view-all-books";
    }

    @GetMapping("/add")
    public String create() {
        return "books/add-book";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("bookForm") BookDTO newBook) {
        log.info(newBook.toString());
        bookService.create(newBook);
        return "redirect:/books";
    }
}
