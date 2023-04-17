package airlineReservationSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import airlineReservationSystem.entities.Passenger;

@Repository
@CrossOrigin("http://localhost:4200")
public interface PassengerDao extends JpaRepository<Passenger, Integer> {
	
	@Query("SELECT p FROM Passenger p where p.user.id =:userId AND p.flightDate =:flightDate")
	public List<Passenger> findByUserIdAndDate(@Param("userId") int userId ,@Param("flightDate") String flightDate);
}
