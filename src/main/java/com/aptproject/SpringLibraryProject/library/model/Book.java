package com.aptproject.SpringLibraryProject.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table (name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book extends GenericModel{
    @Id
    @Column(name = "id")

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_generator")
    private Long id;

    @Column(name = "title", nullable = false)
    private String bookTitle;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "publish_date", nullable = false)
    private String publishDate;

    @Column(name = "amount", nullable = false)
    private String amount;

    @Column(name = "storage_place", nullable = false)
    private String storagePlace;

    @Column(name = "online_copy_path")
    private String onlineCopyPath;

    @Column(name = "genre", nullable = false)
    @Enumerated (value = EnumType.STRING) // чтобы enum нее выводился в числовом значении
    private Genre genre;

    @Column(name = "description")
    private String description;

//    @JsonIgnore
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "books_authors",
    joinColumns = @JoinColumn(name = "book_id"), foreignKey = @ForeignKey(name = "FK_BOOKS_AUTHORS"),
    inverseJoinColumns = @JoinColumn(name = "author_id"), inverseForeignKey = @ForeignKey(name = "FK_AUTHORS_BOOKS"))
    List<Author> authors;
}