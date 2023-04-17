package airlineReservationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import airlineReservationSystem.entities.FareCategories;
import airlineReservationSystem.services.FareCategoriesServices;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class FareCategoriesController {
	
	@Autowired
	private FareCategoriesServices fareCategoriesServices;
	
	@GetMapping("/fare-categories")
	public List<FareCategories> getFareCategories(){
		return this.fareCategoriesServices.getFareCategories();
	}
	
	@GetMapping("fare-category")
	public FareCategories getFareByCatId(@RequestParam("categoryId") int catId) {
		return this.fareCategoriesServices.getByCatId(catId);
	}
}
