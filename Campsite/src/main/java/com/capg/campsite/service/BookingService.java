package com.capg.campsite.service;
 
import java.time.LocalDate;
import java.util.List;
 
import com.capg.campsite.dto.BookingDto;
import com.capg.campsite.entity.Booking;
import com.capg.campsite.exception.BookingDateRangeException;
import com.capg.campsite.exception.BookingNotFoundException;

 
public interface BookingService {
    public List<Booking> getAllBookings() throws BookingNotFoundException;
 
    public Booking addBooking(BookingDto booking, int campsiteId) throws BookingDateRangeException, BookingNotFoundException;
 
    public Booking getBookingById(long bookingId) throws BookingNotFoundException;
 
    public Booking updateBooking(BookingDto booking,long id) throws BookingNotFoundException;
 
    public void deleteBooking(long bookingId) throws BookingNotFoundException;
 
    public List<Booking> findAvailableBookings(LocalDate arrivalDate, LocalDate departureDate);
 
}
