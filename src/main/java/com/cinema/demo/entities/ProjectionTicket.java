package com.cinema.demo.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ticketProj",types = {com.cinema.demo.entities.Ticket.class})
public interface ProjectionTicket {
    public Long getId();
    public String getNomClient();
    public double getPrix();
    public Integer getCodePayment();
    public boolean getReserve();
    public Place getPlace();
}
