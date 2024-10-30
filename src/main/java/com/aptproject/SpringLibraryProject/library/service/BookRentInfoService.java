package com.aptproject.SpringLibraryProject.library.service;

import com.aptproject.SpringLibraryProject.library.dto.BookRentInfoDTO;
import com.aptproject.SpringLibraryProject.library.mapper.BookRentInfoMapper;
import com.aptproject.SpringLibraryProject.library.model.BookRentInfo;
import com.aptproject.SpringLibraryProject.library.repository.BookRentInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class BookRentInfoService
        extends GenericService<BookRentInfo, BookRentInfoDTO> {
    protected BookRentInfoService(BookRentInfoRepository bookRentInfoRepository,
                                  BookRentInfoMapper bookRentInfoMapper) {
        super(bookRentInfoRepository, bookRentInfoMapper);
    }
}
