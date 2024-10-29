package com.aptproject.SpringLibraryProject.library.repository;


import com.aptproject.SpringLibraryProject.library.model.GenericModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository <T extends GenericModel> extends JpaRepository<T, Long>{
    //Только
}
