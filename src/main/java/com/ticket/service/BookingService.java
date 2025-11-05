package com.ticket.service;

import com.ticket.entity.Booking;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingService {

    public Booking postBooking(Booking booking);
//post list
    public List<Booking> postBookingList(List<Booking> bookings);
//get list
    public List<Booking> getAllBooking();
//get by id
    public Booking getBookingById(int id);
//update details
    public Booking updateBooking(Booking booking , int id );
    // cancel delete
    public String deleteBookingById(int id);
}
