package com.aptproject.SpringLibraryProject.library.repository;

import com.aptproject.SpringLibraryProject.library.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends  GenericRepository<User>{
}
