package com.cinema.demo.dao;

import com.cinema.demo.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RepositoryRestResource
@CrossOrigin("*")
public interface CategoryRepository
        extends JpaRepository<Categorie, Long> {
}
