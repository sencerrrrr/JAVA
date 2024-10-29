package com.aptproject.SpringLibraryProject.library.controller;


import com.aptproject.SpringLibraryProject.library.model.GenericModel;
import com.aptproject.SpringLibraryProject.library.repository.GenericRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j //логгер в командной строке
public abstract class GenericController <T extends GenericModel> {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(GenericController.class);
    private final GenericRepository<T> genericRepository;

    protected GenericController(GenericRepository<T> genericRepository) {
        this.genericRepository = genericRepository;
    }
    @Operation(description = "ПОлучить запись по ID", method = "getOneById") // появится описание в Swagger
    @RequestMapping(value = "/getOneById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> getOneById(@RequestParam(value = "id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(genericRepository.findById(id).orElseThrow(() -> new NotFoundException("Данные по заданному ID не найдены")));
    }

    @Operation(description = "Получить все записи", method = "getAll")
    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE) // сразу указали тп маппинга "get"
    public ResponseEntity<List<T>> getAll() {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(genericRepository.findAll());
    }

    @Operation(description = "Создать запись", method = "create")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> create(@RequestBody T newEntity) {
        newEntity.setCreatedWhen(LocalDate.now());
        log.info(newEntity.toString());
        genericRepository.save(newEntity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newEntity);
    }

    @Operation(description = "Обновить запись", method = "update")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> update(@RequestBody T updateEntity, @RequestParam(value = "id") Long id) {
        updateEntity.setId(id);
        genericRepository.save(updateEntity);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateEntity);
    }


    //localhost:8080/authors/delete/1 - @@PathVariable
    @Operation(description = "Удалить запись", method = "delete")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        genericRepository.deleteById(id);
    }
}


