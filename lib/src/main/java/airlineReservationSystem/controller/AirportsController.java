package airlineReservationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import airlineReservationSystem.entities.Airports;
import airlineReservationSystem.services.AiportsServices;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class AirportsController {
	
	@Autowired
	private AiportsServices airportsServices;
	
	@GetMapping("/airports")
	public List<Airports> getAirports(){
		return this.airportsServices.getAirports();
	}
}
