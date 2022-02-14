package com.flightapp.booking.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.booking.exception.RecordAlreadyPresentException;
import com.flightapp.booking.exception.RecordNotFoundException;
import com.flightapp.booking.models.Booking;
import com.flightapp.booking.repository.BookingRepository;




@Service
public class BookingServiceImpl implements BookingService {

	
	@Autowired
	BookingRepository bookingRepository;

	/*
	 * making new Booking
	 */
	@Override
	public ResponseEntity<Booking> createBooking(Booking newBooking) {

		Optional<Booking> findBookingById = bookingRepository.findById(newBooking.getBookingId());
		try {
			if (!findBookingById.isPresent()) {
				bookingRepository.save(newBooking);
				return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException(
						"Booking with Booking Id: " + newBooking.getBookingId() + " already exists!!");
		} catch (RecordAlreadyPresentException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * update booking made
	 */
	@Override
	public Booking updateBooking(Booking changedBooking) {
		Optional<Booking> findBookingById = bookingRepository.findById(changedBooking.getBookingId());
		if (findBookingById.isPresent()) {
			bookingRepository.save(changedBooking);
		} else
			throw new RecordNotFoundException(
					"Booking with Booking Id: " + changedBooking.getBookingId() + " not exists!!");
		return changedBooking;
	}

	/*
	 * deleteing the booking
	 */

	@Override
	public String deleteBooking(int bookingId) {

		Optional<Booking> findBookingById = bookingRepository.findById(bookingId);
		if (findBookingById.isPresent()) {
			bookingRepository.deleteById(bookingId);
			return "Booking Deleted!!";
		} else
			throw new RecordNotFoundException("Booking not found for the entered BookingID");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.service.BookingService#displayAllBooking() show all booking
	 */
	@Override
	public Iterable<Booking> displayAllBooking() {

		return bookingRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.service.BookingService#findBookingById(java.math.int)
	 * find booking by ID
	 */
	@Override
	@Cacheable(key="#id", value="airlineBook")
	public ResponseEntity<?> findBookingById(int bookingId) {
		Optional<Booking> findById = bookingRepository.findById(bookingId);
		try {
			if (findById.isPresent()) {
				Booking findBooking = findById.get();
				return new ResponseEntity<Booking>(findBooking, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + bookingId);
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Booking findBookingById(String emailId) {
		
		return bookingRepository.findByEmailId(emailId);
	}

	/*
	 * @Override public void deleteByEmailId(String emailId) {
	 * 
	 * bookingRepository.deleteByEmailId(emailId);
	 * 
	 * }
	 */
	
	
}
