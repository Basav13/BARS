package airlineReservationSystem.services;

import java.util.List;

import airlineReservationSystem.entities.Booking;

public interface BookingServices {
	
	public void bookFlight(int userId , String flightDate);
	public List<Booking> getByUserId(int userId);
	public Booking getByBookingId(int bookingId);
	public String cancelBooking(int bookingId);
}
