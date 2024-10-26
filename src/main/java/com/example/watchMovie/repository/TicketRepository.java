package com.example.watchMovie.repository;

import com.example.watchMovie.entity.Ticket;
import com.example.watchMovie.supportingEntity.TicketId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, TicketId> {
}
