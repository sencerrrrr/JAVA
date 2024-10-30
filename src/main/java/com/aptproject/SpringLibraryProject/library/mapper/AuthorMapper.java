package com.aptproject.SpringLibraryProject.library.mapper;

import com.aptproject.SpringLibraryProject.library.dto.AuthorDTO;
import com.aptproject.SpringLibraryProject.library.model.Author;
import com.aptproject.SpringLibraryProject.library.model.GenericModel;
import com.aptproject.SpringLibraryProject.library.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import org.hibernate.mapping.Collection;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AuthorMapper
        extends GenericMapper<Author, AuthorDTO> {

    private final BookRepository bookRepository;

    public AuthorMapper(ModelMapper modelMapper,
                        BookRepository bookRepository) {
        super(Author.class, AuthorDTO.class, modelMapper);
        this.bookRepository = bookRepository;
    }

    //настройки маппинга нестандартных полей
    @PostConstruct
    protected void setupMapper() {
        modelMapper.createTypeMap(Author.class, AuthorDTO.class)
                .addMappings(mapping -> mapping.skip(AuthorDTO::setBooksIds)).setPostConverter((toDTOConverter()));
        modelMapper.createTypeMap(AuthorDTO.class, Author.class)
                .addMappings(mapping -> mapping.skip(Author::setBooks)).setPostConverter(toEntityConverter());
    }

    //маппинг нестандартных полей з ДТО в модель
    @Override
    protected void  mapSpecificFields(AuthorDTO source, Author destination) {
        if (!Objects.isNull(source.getBooksIds())) {
            destination.setBooks(bookRepository.findAllById(source.getBooksIds()));
        } else{
            destination.setBooks(Collections.emptyList());
        }
    }

    //маппинг нестандартных полей из модели в ЖТО
    @Override
    protected void mapSpecificFields(Author source, AuthorDTO destination) {
        destination.setBooksIds(getIds(source));
    }

    @Override
    protected List<Long> getIds(Author source) {
        return Objects.isNull(source) || Objects.isNull(source.getBooks())
                ? Collections.emptyList()
                : source.getBooks().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toList());
    }
}
