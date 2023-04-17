package airlineReservationSystem.services;

import java.util.List;

import airlineReservationSystem.entities.Passenger;

public interface PassengerServices {
	public List<Passenger> getAllPassengers();
	public Passenger findById(int passId);
	public void savePassenger(Passenger passenger);
	public void saveAllPassengers(List<Passenger> passengers);
	public List<Passenger> getByUserIdAndDate(int userId, String flightDate);
}
