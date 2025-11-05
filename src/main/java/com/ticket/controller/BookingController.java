package com.ticket.controller;

import com.ticket.entity.Booking;
import com.ticket.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/post")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking){
        Booking postBooking = bookingService.postBooking(booking);
        return new ResponseEntity<>(postBooking , HttpStatus.CREATED);
    }

    @PostMapping("/PostList")
    public ResponseEntity<List<Booking>> postBookingList(@RequestBody List<Booking> bookings){
        List<Booking> bookingList = bookingService.postBookingList(bookings);
       return  new ResponseEntity<>(bookingList , HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Booking>> getAllBooking(){
        List<Booking> bookingList = bookingService.getAllBooking();
    return  new ResponseEntity<>(bookingList, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int id){
        Booking getBookingById = bookingService.getBookingById(id);
        return new ResponseEntity<>(getBookingById , HttpStatus.OK);
    }

    @PutMapping("/updateBooking/{id}")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking , @PathVariable int id ){
        Booking updateBooking = bookingService.updateBooking(booking, id);
        return new ResponseEntity<>(updateBooking , HttpStatus.OK);
    }
    @DeleteMapping("/deleteBooking/{id}")
    public ResponseEntity<String> deleteBookingById(@PathVariable int id){
        String s = bookingService.deleteBookingById(id);
        return new ResponseEntity<>(s , HttpStatus.OK);
    }
}
