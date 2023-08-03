package com.example.watchMovie.controller;

import com.example.watchMovie.entity.Ticket;
import com.example.watchMovie.service.TicketService;
import com.example.watchMovie.supportingEntity.TicketId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicletController {
    @Autowired
    private TicketService service;

    @PostMapping("/addTicket")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        System.out.println(ticket);
        return ResponseEntity.ok(this.service.createTicket(ticket));
    }

    @PostMapping("/addTickets")
    public ResponseEntity<List<Ticket>> createTickets(@RequestBody List<Ticket> tickets) {
        return ResponseEntity.ok(service.createTicketList(tickets));
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getTickets() {
        return ResponseEntity.ok(service.getTicketList());
    }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable TicketId id) {
        return ResponseEntity.ok(service.getTicketById(id));
    }

    @PutMapping("/updateTicket")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok().body(service.updateTicketById(ticket));
    }

    @DeleteMapping("/deleteTicket/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable TicketId id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

}
