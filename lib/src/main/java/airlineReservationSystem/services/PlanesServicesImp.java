package airlineReservationSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airlineReservationSystem.dao.PlanesDao;
import airlineReservationSystem.entities.Planes;

@Service
public class PlanesServicesImp implements PlanesServices {
	
	@Autowired
	private PlanesDao planesDao;
	
	@Override
	public List<Planes> getPlanes() {
		// TODO Auto-generated method stub
		return this.planesDao.findAll();
	}

}
