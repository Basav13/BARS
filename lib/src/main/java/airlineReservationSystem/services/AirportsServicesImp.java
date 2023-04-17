package airlineReservationSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airlineReservationSystem.dao.AirportsDao;
import airlineReservationSystem.entities.Airports;

@Service
public class AirportsServicesImp implements AiportsServices {

	@Autowired
	private AirportsDao airportsDao;
	
	@Override
	public List<Airports> getAirports() {
		
		return this.airportsDao.findAll();	
	}

}
