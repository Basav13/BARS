package airlineReservationSystem.services;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airlineReservationSystem.dao.BookingDao;
import airlineReservationSystem.dao.FlightDao;
import airlineReservationSystem.dao.PassengerDao;
import airlineReservationSystem.entities.Booking;
import airlineReservationSystem.entities.Flight;
import airlineReservationSystem.entities.Passenger;

@Service
public class BookingServicesImp implements BookingServices {
	
	@Autowired
	private PassengerDao passengerDao;
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired 
	private FlightDao flightDao;

	@Override
	public void bookFlight(int userId , String flightDate) {
		// TODO Auto-generated method stub
		
		
		LocalDateTime lastUpdTime = LocalDateTime.now();
		
		List<Passenger> passList = new ArrayList<Passenger>();
		passList = this.passengerDao.findByUserIdAndDate(userId, flightDate);
		System.out.println(passList);
		
		SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[12];
        random.nextBytes(bytes);
        String reference = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
		String refNo = reference.substring(0,9);
		
		int num = passList.size();
		
		for(int i = 0 ; i < num ; i++) {
			Booking booking = new Booking();
			
			booking.setRefNo(refNo);
			
			booking.setUser(passList.get(i).getUser());
			
			System.out.println(passList.get(i).getFlightId()); 
			Optional<Flight> flt = flightDao.findById(passList.get(i).getFlightId());
			Flight flight = flt.get();
			int seats = flight.getSeats();
			seats = seats-1;
			flight.setSeats(seats);
			booking.setFlight(flight);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate flDate = LocalDate.parse(passList.get(i).getFlightDate(), formatter);
			booking.setFlightDate(flDate);
			
			
			booking.setFareCategory(passList.get(i).getCategory());
			
			booking.setAmount(passList.get(i).getBookingAmount());
			
			booking.setStatus("CONFIRMED");
			
			booking.setLastUpdateTime(lastUpdTime);
			
			booking.setfName(passList.get(i).getFirstName());
			
			booking.setlName(passList.get(i).getLastName());
			
			this.bookingDao.save(booking);
		}
	}

	@Override
	public List<Booking> getByUserId(int userId) {
		// TODO Auto-generated method stub
		return this.bookingDao.getByUserId(userId);
	}

	@Override
	public Booking getByBookingId(int bookingId) {
		// TODO Auto-generated method stub
		Optional<Booking> bk = this.bookingDao.findById(bookingId);
		Booking booking = bk.get();
		return booking;
	}

	@Override
	public String cancelBooking(int bookingId) {
		// TODO Auto-generated method stub
		Optional<Booking> bk = this.bookingDao.findById(bookingId);
		Booking booking = bk.get();
		booking.setStatus("CANCELLED");
		this.bookingDao.save(booking);
		return booking.getStatus();		
	}

}
