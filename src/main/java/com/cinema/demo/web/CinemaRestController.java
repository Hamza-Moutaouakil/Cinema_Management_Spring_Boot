package com.cinema.demo.web;

import com.cinema.demo.dao.CinemaRepository;
import com.cinema.demo.dao.FilmRepository;
import com.cinema.demo.dao.TicketRepository;
import com.cinema.demo.entities.Cinema;
import com.cinema.demo.entities.Film;
import com.cinema.demo.entities.Ticket;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class CinemaRestController {
    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private  FilmRepository filmRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @GetMapping(value = "/imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable (name ="id")Long id)throws Exception{
        Film film=filmRepository.findById(id).get();
        String photoName=film.getPhoto();
        File file=new File(System.getProperty("user.home")+"/cinema/images/"+photoName);
        Path path= Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }
    @PostMapping("/payerTickets")
    @Transactional
    public List<Ticket> payerTickets(@RequestBody TicketFrom ticketFrom){
        List<Ticket> tickets=new ArrayList<>();
        ticketFrom.getTickets().forEach(id->{
            Ticket ticket=ticketRepository.findById(id).get();
            ticket.setNomClient(ticketFrom.getNomClient());
            ticket.setReserve(true);
            ticket.setCodePayment(ticketFrom.getCodePayment());
            ticketRepository.save(ticket);
            tickets.add(ticket);
        });
        return tickets;
    }
}


@Data
class TicketFrom{
    private String nomClient;
    private int codePayment;
    private List<Long> tickets=new ArrayList<>();
}