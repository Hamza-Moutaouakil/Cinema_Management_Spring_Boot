package com.cinema.demo.dao;

import com.cinema.demo.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.springframework.web.bind.annotation.RestController;


@RepositoryRestResource
public interface VilleRepository extends JpaRepository<Ville, Long> {
}
