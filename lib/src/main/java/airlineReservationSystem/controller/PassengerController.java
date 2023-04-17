package airlineReservationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import airlineReservationSystem.entities.Passenger;
import airlineReservationSystem.services.PassengerServices;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class PassengerController {
	
	@Autowired
	private PassengerServices passengerServices;
	
	@GetMapping("/passengers")
	public List<Passenger> getAllPassengers(){
		return this.passengerServices.getAllPassengers();
	}
	
	@GetMapping("/passenger/{passId}")
	public Passenger getPassenger(@PathVariable String passId) {
		return this.passengerServices.findById(Integer.parseInt(passId));
	}
	
	@PostMapping(path="/passenger",consumes="application/json")
	public ResponseEntity<HttpStatus> addPassenger(@RequestBody Passenger passenger){
		try {
			this.passengerServices.savePassenger(passenger);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/add-passengers",consumes="application/json")
	public ResponseEntity<HttpStatus> addAllPassenger(@RequestBody List<Passenger> passenger){
		try {
			this.passengerServices.saveAllPassengers(passenger);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/passengers-book")
	public List<Passenger> getByUserIdAndDate(@RequestParam("userId") int userId,
											@RequestParam("flightDate") String flightDate){
		return this.passengerServices.getByUserIdAndDate(userId, flightDate);
	}
	
}
