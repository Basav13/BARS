package airlineReservationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import airlineReservationSystem.entities.Routes;
import airlineReservationSystem.services.RoutesServices;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class RoutesController {
	
	@Autowired
	private RoutesServices routesServices;
	
	@GetMapping("/routes")
	public List<Routes> getRoutes(){
		return this.routesServices.getRoutes();
	}
}
