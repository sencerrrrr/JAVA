package com.aptproject.SpringLibraryProject.library.repository;

import  com.aptproject.SpringLibraryProject.library.model.Author;
import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends GenericRepository<Author>{

}
