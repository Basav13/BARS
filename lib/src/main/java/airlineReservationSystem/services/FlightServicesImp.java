package airlineReservationSystem.services;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airlineReservationSystem.dao.FlightDao;
import airlineReservationSystem.entities.Flight;


@Service
public class FlightServicesImp implements FlightServices {
	
	@Autowired
	private FlightDao flightDao;
		
	@Override
	public List<Flight> getFlights() {
		// TODO Auto-generated method stub
		return this.flightDao.findAll();
	}

	@Override
	public List<Object[]> searchFlights(int sourceId, int destId , String sortField) {
		// TODO Auto-generated method stub
		return this.flightDao.findFlights(sourceId,destId,sortField);
	}

	@Override
	public int getFlightId(String planeId, int sourceId, int destId, LocalTime slotFrom, LocalTime slotTo) {
		// TODO Auto-generated method stub
		return this.flightDao.findFlightIdByPlaneIdAndSourceIdAndDestIdAndSlotFromAndSlotTo(planeId, sourceId, destId, slotFrom, slotTo);
	}

}
