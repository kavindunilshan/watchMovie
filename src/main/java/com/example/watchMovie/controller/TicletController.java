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

    @PostMapping("/tickets")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        System.out.println(ticket);
        return ResponseEntity.ok(this.service.createTicket(ticket));
    }

    @PostMapping("/ticketsList")
    public ResponseEntity<List<Ticket>> createTickets(@RequestBody List<Ticket> tickets) {
        return ResponseEntity.ok(service.createTicketList(tickets));
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getTickets() {
        return ResponseEntity.ok(service.getTicketList());
    }

    @GetMapping("/tickets/{tid}/{tc_id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable String tid, @PathVariable int tc_id) {
        TicketId id = new TicketId(tid, tc_id);
        return ResponseEntity.ok(service.getTicketById(id));
    }

    @PutMapping("/tickets")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok().body(service.updateTicket(ticket));
    }

    @PatchMapping("/tickets")
    public ResponseEntity<Ticket> updateTicketPart(@RequestBody Ticket ticket) {
        return ResponseEntity.ok().body(service.updateTicketById(ticket));
    }

    @DeleteMapping("/tickets/{tid}/{tc_id}")
    public ResponseEntity<String> deleteTicket(@PathVariable String tid, @PathVariable int tc_id) {
        TicketId id = new TicketId(tid, tc_id);
        return ResponseEntity.ok(service.deleteById(id));
    }

}
