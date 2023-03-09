package com.capg.campsite.service;
 

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
 
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.repository.CrudRepository;
 
import com.capg.campsite.dto.BookingDto;
import com.capg.campsite.entity.Booking;
import com.capg.campsite.entity.Campsite;
import com.capg.campsite.exception.BookingNotFoundException;
//import com.capg.campsite.exception.ResourceNotFoundException;
import com.capg.campsite.repository.BookingRepository;
import com.capg.campsite.repository.CampsiteRepository;
 
@ExtendWith(MockitoExtension.class)
 
public class BookingServiceTest {
 
        @Mock
        private BookingRepository bookingRepository;

        @InjectMocks
        private BookingServiceImpl bookingService;
 
        @Test
        public void testGetAllBookings() throws BookingNotFoundException {
            
            List<Booking> bookings = Arrays.asList(new Booking(), new Booking(), new Booking());
            when(bookingRepository.findAll()).thenReturn(bookings);
 
            
            List<Booking> result = bookingService.getAllBookings();
 
            
            assertThat(result).isEqualTo(bookings);
        }
        @Test
        public void testGetBookingById() throws BookingNotFoundException {
            
            long bookingId = 123L;
            Booking booking = new Booking();
            when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(booking));
 
            Booking result = bookingService.getBookingById(bookingId);
 
            
            assertThat(result).isEqualTo(booking);
        }
        @Test
        public void testFindAvailableBookings() {
            
            LocalDate arrivalDate = LocalDate.of(2023, 3, 6);
            LocalDate departureDate = LocalDate.of(2023, 3, 8);
            Booking booking1 = new Booking(1L, LocalDate.of(2023, 3, 4), LocalDate.of(2023, 3, 7), true, LocalDate.now(),null);
            Booking booking2 = new Booking(2L, LocalDate.of(2023, 3, 5), LocalDate.of(2023, 3, 9), true, LocalDate.now(),null);
            Booking booking3 = new Booking(3L, LocalDate.of(2023, 3, 7), LocalDate.of(2023, 3, 10), true, LocalDate.now(),null);
            List<Booking> bookings = new ArrayList<>();
            bookings.add(booking1);
            bookings.add(booking2);
            bookings.add(booking3);

            when(bookingRepository.findAll()).thenReturn(bookings);

            
            List<Booking> availableBookings = bookingService.findAvailableBookings(arrivalDate, departureDate);

            
        }
        @Test
        public void testDeleteBooking() throws BookingNotFoundException {
            
            long bookingId = 1L;
            Booking booking = new Booking(bookingId, LocalDate.of(2023, 3, 6), LocalDate.of(2023, 3, 8), true,
                    LocalDate.now(), null);
            when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(booking));
            doNothing().when(bookingRepository).delete(any(Booking.class));

            
            bookingService.deleteBooking(bookingId);

        }
        @Test
        public void testAddBooking() throws Exception {
           
            BookingDto bookingDto = new BookingDto(null, null, false, 0);
            bookingDto.setArrivalDate(LocalDate.now().plusMonths(1));
            bookingDto.setDepartureDate(LocalDate.now().plusMonths(2));
            bookingDto.setAvailability(true);

            int campsiteId = 1;
            Campsite campsite = new Campsite();
            campsite.setSiteId(campsiteId);

        }
        }

