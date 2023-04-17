package airlineReservationSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import airlineReservationSystem.entities.Routes;

@Repository
@CrossOrigin("http://localhost:4200")
public interface RoutesDao extends JpaRepository<Routes,Integer> {

}
