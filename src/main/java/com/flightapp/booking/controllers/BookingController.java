package com.flightapp.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.booking.exception.RecordAlreadyPresentException;
import com.flightapp.booking.exception.RecordNotFoundException;
import com.flightapp.booking.models.Booking;
import com.flightapp.booking.security.services.BookingService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1.0/flight/booking")
public class BookingController {

	@Autowired(required = true)
	BookingService bookingService;

	//@PreAuthorize("hasRole('USER')")
	@PostMapping("/createBooking")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addBooking(@RequestBody Booking newBooking) {

		bookingService.createBooking(newBooking);
	}

	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/readAllBooking")
	public Iterable<Booking> readAllBookings() {

		return bookingService.displayAllBooking();
	}

	//@PreAuthorize("hasRole('USER')")
	@PutMapping("/updateBooking")
	// @ExceptionHandler(RecordNotFoundException.class)
	public void modifyBooking(@RequestBody Booking updateBooking) {

		bookingService.updateBooking(updateBooking);
	}

	/*
	 * @PreAuthorize("hasRole('USER')")
	 * 
	 * @GetMapping("/searchBooking/{id}")
	 * //@ExceptionHandler(RecordNotFoundException.class) public ResponseEntity<?>
	 * searchBookingByID(@PathVariable("id") int bookingId) {
	 * 
	 * return bookingService.findBookingById(bookingId); }
	 */

	//@PreAuthorize("hasRole('USER')")
	@GetMapping("/searchBooking/{emailId}")
	// @ExceptionHandler(RecordNotFoundException.class)
	public Booking searchBookingByEmailID(@PathVariable("emailId") String emailId) {

		return bookingService.findBookingById(emailId);
	}

	  //@PreAuthorize("hasRole('USER')")
	  @DeleteMapping("/cancelBooking/{id}")
	  @ExceptionHandler(RecordNotFoundException.class)
	public void deleteBookingByID(@PathVariable("id") int bookingId) {
	  
	  bookingService.deleteBooking(bookingId); 
	  }

	/*
	 * @PreAuthorize("hasRole('USER')")
	 * 
	 * @DeleteMapping("/cancelBooking/{emailId}")
	 * //@ExceptionHandler(RecordNotFoundException.class) public void
	 * deleteBookingByID(@PathVariable("emailId") String emailId) {
	 * 
	 * bookingService.deleteByEmailId(emailId); }
	 */

}
