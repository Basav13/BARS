package airlineReservationSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airlineReservationSystem.dao.FlightSlotsDao;
import airlineReservationSystem.entities.FlightSlots;

@Service
public class FlightSlotsServicesImp implements FlightSlotsServices {

	@Autowired
	private FlightSlotsDao flightSlotsDao;
	
	@Override
	public List<FlightSlots> getFlightSlots() {
		// TODO Auto-generated method stub
		return this.flightSlotsDao.findAll();
	}

}
