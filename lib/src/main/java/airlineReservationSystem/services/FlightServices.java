package airlineReservationSystem.services;

import java.time.LocalTime;
import java.util.List;

import airlineReservationSystem.entities.Flight;


public interface FlightServices {
	public List<Flight> getFlights();
	public List<Object[]> searchFlights(int sourceId, int destId , String sortField);
	public int getFlightId(String planeId , int sourceId , int destId , LocalTime slotFrom , LocalTime slotTo);
}
