package com.aptproject.SpringLibraryProject.library.controller;


import com.aptproject.SpringLibraryProject.library.model.BookRentInfo;
import com.aptproject.SpringLibraryProject.library.repository.BookRentInfoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rent/info")
@Tag(name = "Аренда книг",
        description = "Контроллер для работы с арендой/выдачей книг польб=зователям библиотеки")
public class RentBookController
            extends GenericController<BookRentInfo> {
    public RentBookController(BookRentInfoRepository genericRepository) {
        super(genericRepository);
    }
}
