package airlineReservationSystem.services;

import java.util.List;

import airlineReservationSystem.entities.FareCategories;

public interface FareCategoriesServices {
	
	public List<FareCategories> getFareCategories();
	public FareCategories getByCatId(int catId);
}
