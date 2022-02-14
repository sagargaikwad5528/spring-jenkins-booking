package com.flightapp.booking.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.booking.models.Booking;



@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	public Booking findByEmailId(String emailId);
	

}
