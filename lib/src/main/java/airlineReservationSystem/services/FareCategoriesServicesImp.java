package airlineReservationSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airlineReservationSystem.dao.FareCategoriesDao;
import airlineReservationSystem.entities.FareCategories;

@Service
public class FareCategoriesServicesImp implements FareCategoriesServices {
	
	@Autowired
	private FareCategoriesDao fareCategoriesDao;
	
	@Override
	public List<FareCategories> getFareCategories() {
		// TODO Auto-generated method stub
		return fareCategoriesDao.findAll();
	}

	@Override
	public FareCategories getByCatId(int catId) {
		// TODO Auto-generated method stub
		return fareCategoriesDao.getByCategoryId(catId);
	}

}
