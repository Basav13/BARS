package airlineReservationSystem.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import airlineReservationSystem.entities.Airports;

@Repository
@CrossOrigin("http://localhost:4200")
public interface AirportsDao extends JpaRepository<Airports, BigDecimal> {

}
