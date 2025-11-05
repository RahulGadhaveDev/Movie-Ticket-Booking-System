package com.ticket.service;

import com.ticket.entity.Booking;
import com.ticket.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking postBooking(Booking booking) {
        Booking postBooking = bookingRepository.save(booking);
        return postBooking;
    }

    @Override
    public List<Booking> postBookingList(List<Booking> bookings) {

        List<Booking> bookingList = new ArrayList<>();

        for(Booking booking:bookings){
            Booking bookingDetails=bookingRepository.save(booking);
            bookingList.add(bookingDetails);
        }
        return bookingList;
    }

    @Override
    public List<Booking> getAllBooking() {
        List<Booking> bookingList = bookingRepository.findAll();
        return bookingList;
    }

    @Override
    public Booking getBookingById(int id) {
        Booking BookingDetails = bookingRepository.findById(id).orElseThrow(()-> new RuntimeException("Booking Not Comfirn for"+ id));
        return BookingDetails;
    }

    @Override
    public Booking updateBooking(Booking booking, int id) {
        Booking update= bookingRepository.findById(id).orElseThrow(()-> new RuntimeException("not found booking details"));
        update.setMovieName(booking.getMovieName());
        update.setShowTime(booking.getShowTime());

        Booking updateBooking = bookingRepository.save(update);
        return updateBooking;
    }

    @Override
    public String deleteBookingById(int id) {
        bookingRepository.deleteById(id);
        return "delete succ";
    }
}
