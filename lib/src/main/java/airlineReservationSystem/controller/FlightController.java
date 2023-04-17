package airlineReservationSystem.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import airlineReservationSystem.entities.Flight;
import airlineReservationSystem.services.FlightServices;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class FlightController {
	
	@Autowired
	private FlightServices flightServices;
	
	@GetMapping("/flights")
	public List<Flight> getFlights(){
		return this.flightServices.getFlights();
	}
	
	@GetMapping("/search-flights")
	public List<Object[]> searchFlights(@RequestParam("sourceId") String sourceId,
										@RequestParam("destId") String destId,
										@RequestParam(value = "sortField",required=false) String sortField){
		return this.flightServices.searchFlights(Integer.parseInt(sourceId),Integer.parseInt(destId),sortField);
	}
	
	@GetMapping("/flight-search")
	public int getFId(@RequestParam("planeId") String planeId,
			@RequestParam("sourceId") int sourceId,
			@RequestParam("destId") int destId,
			@RequestParam("slotFrom") LocalTime slotFrom,
			@RequestParam("slotTo") LocalTime slotTo) {
		int id = this.flightServices.getFlightId(planeId,sourceId, destId, slotFrom, slotTo);
		System.out.println(id);
		return id;
	}
}
