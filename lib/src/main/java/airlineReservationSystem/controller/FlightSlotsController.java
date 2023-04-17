package airlineReservationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import airlineReservationSystem.entities.FlightSlots;
import airlineReservationSystem.services.FlightSlotsServices;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class FlightSlotsController {
	
	@Autowired
	private FlightSlotsServices flightSlotsServices;
	
	@GetMapping("/flight-slots")
	public List<FlightSlots> getFlightSlots(){
		return this.flightSlotsServices.getFlightSlots();
	}
}
