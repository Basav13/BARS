package airlineReservationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import airlineReservationSystem.entities.Booking;
import airlineReservationSystem.services.BookingServices;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class BookingController {
	
	@Autowired
	private BookingServices bookingServices;
	
	@GetMapping("/book")
	public void bookFlight(@RequestParam("userId") int userId ,@RequestParam("flightDate") String flightDate) {
		this.bookingServices.bookFlight(userId, flightDate);
	}
	
	@GetMapping("/get-bookings")
	public List<Booking> getByUserId(@RequestParam("userId") int userId){
		return this.bookingServices.getByUserId(userId);
	}
	
	@GetMapping("/get-booking/{bookingId}")
	public Booking getByBoookingId(@PathVariable String bookingId) {
		return this.bookingServices.getByBookingId(Integer.parseInt(bookingId));
	}
	
	@GetMapping("/cancel-booking")
	public String cancelBooking(@RequestParam("bookingId") int bookingId) {
		return this.bookingServices.cancelBooking(bookingId);
	}
}
