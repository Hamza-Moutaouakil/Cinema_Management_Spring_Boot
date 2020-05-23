package com.cinema.demo;

import com.cinema.demo.dao.CategoryRepository;
import com.cinema.demo.entities.Categorie;
import com.cinema.demo.entities.Film;
import com.cinema.demo.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired  private ICinemaInitService cinemaInitService;
    @Autowired private RepositoryRestConfiguration restConfiguration;
    @Autowired private CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    public void run (String... args) throws Exception {
        restConfiguration.exposeIdsFor(Film.class);
        cinemaInitService.initCategories();
        cinemaInitService.initCinemas();
        cinemaInitService.initFilms();
        cinemaInitService.initPlaces();
        cinemaInitService.initProjections();
        cinemaInitService.initSalles();
        cinemaInitService.initTickets();


    }


}
