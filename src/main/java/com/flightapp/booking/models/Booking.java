package com.flightapp.booking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bookingtbl")
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookingId;
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prnNo;
	private String name;
	private String gender;
	private String age;
	private String emailId;
	private String meal;
	private int noOfPassengers;
	private int seatNumber;
	
	
	public Booking() {}
	
	
	
	public Booking(int bookingId, int prnNo, String name, String gender, String age, String emailId, String meal,
			int noOfPassengers, int seatNumber) {
		super();
		this.bookingId = bookingId;
		this.prnNo = prnNo;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.emailId = emailId;
		this.meal = meal;
		this.noOfPassengers = noOfPassengers;
		this.seatNumber = seatNumber;
	}



	public int getBookingId() {
		return bookingId;
	}



	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}



	public int getPrnNo() {
		return prnNo;
	}



	public void setPrnNo(int prnNo) {
		this.prnNo = prnNo;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getMeal() {
		return meal;
	}



	public void setMeal(String meal) {
		this.meal = meal;
	}



	public int getNoOfPassengers() {
		return noOfPassengers;
	}



	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}



	public int getSeatNumber() {
		return seatNumber;
	}



	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}



	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", prnNo=" + prnNo + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + ", emailId=" + emailId + ", meal=" + meal + ", noOfPassengers=" + noOfPassengers
				+ ", seatNumber=" + seatNumber + "]";
	}
	
	
	
	

}
