package airlineReservationSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airlineReservationSystem.dao.RoutesDao;
import airlineReservationSystem.entities.Routes;

@Service
public class RoutesServicesImp implements RoutesServices {
	
	@Autowired
	private RoutesDao routesDao;
	
	@Override
	public List<Routes> getRoutes() {
		// TODO Auto-generated method stub
		return this.routesDao.findAll();
	}

}
