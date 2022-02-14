package com.flightapp.booking.security.services;



import org.springframework.http.ResponseEntity;

import com.flightapp.booking.models.Booking;



public interface BookingService {

	public ResponseEntity<?> createBooking(Booking newBooking);

	public Booking updateBooking(Booking newBooking);

	public String deleteBooking(int bookingId);

	public Iterable<Booking> displayAllBooking();

	public ResponseEntity<?> findBookingById(int bookingId);
	public Booking findBookingById(String emailId);
	//public void deleteByEmailId(String emailId);
	
	
}
