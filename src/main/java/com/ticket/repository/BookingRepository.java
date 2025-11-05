package com.ticket.repository;

import com.ticket.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking , Integer> {
}
