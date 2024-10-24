package com.aptproject.SpringLibraryProject.dbexample.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Date date_added;

}
