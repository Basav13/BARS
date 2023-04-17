package airlineReservationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import airlineReservationSystem.entities.Planes;
import airlineReservationSystem.services.PlanesServices;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class PlanesController {
	
	@Autowired
	private PlanesServices planesServices;
	
	@GetMapping("/planes")
	public List<Planes> getPlanes(){
		return this.planesServices.getPlanes();
	}
}
