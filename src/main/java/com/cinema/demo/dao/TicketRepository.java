package com.cinema.demo.dao;

import com.cinema.demo.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RestController;


@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
