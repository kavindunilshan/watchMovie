package com.example.watchMovie.service;

import com.example.watchMovie.entity.Ticket;
import com.example.watchMovie.exception.IdNotFoundException;
import com.example.watchMovie.repository.TicketRepository;
import com.example.watchMovie.supportingEntity.TicketId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> createTicketList(List<Ticket> list) {
        return ticketRepository.saveAll(list);
    }

    public List<Ticket> getTicketList() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(TicketId id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket updateTicket(Ticket ticket) {
        Optional<Ticket> ticketFound = ticketRepository.findById(ticket.getTicketId());
        if (ticketFound.isPresent()) {
            Ticket ticketUpdate = ticketFound.get();
            ticketUpdate.setFull(ticket.getFull());
            ticketUpdate.setHalf(ticket.getHalf());
            ticketUpdate.setBookedSeats(ticket.getBookedSeats());
            ticketUpdate.setTotal(ticket.getTotal());

            return ticketRepository.save(ticket);
        } else {
            return null;
        }
    }

    public Ticket updateTicketById(Ticket ticket) {
        Optional<Ticket> ticketFound = ticketRepository.findById(ticket.getTicketId());
        if (ticketFound.isPresent()) {
            Ticket ticketUpdate = ticketFound.get();

            if(0 < ticketUpdate.getFull())
                ticketUpdate.setFull(ticket.getFull());

            if(0 < ticketUpdate.getFull())
                ticketUpdate.setHalf(ticket.getHalf());

            // need to change ------------------------=========
            if(0 < ticketUpdate.getBookedSeats().length())
                ticketUpdate.setBookedSeats(ticket.getBookedSeats());

            if(0 < ticketUpdate.getTotal())
                ticketUpdate.setTotal(ticket.getTotal());

            return ticketRepository.save(ticketUpdate);
        } else {
            throw new IdNotFoundException("Invalid ticket Id");
        }
    }

    public String deleteById(TicketId id) {
        ticketRepository.deleteById(id);
        return "Ticket " + id + " is deleted.";
    }

}
