package airlineReservationSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import airlineReservationSystem.entities.Booking;

@Repository
@CrossOrigin("http://localhost:4200")
public interface BookingDao extends JpaRepository<Booking, Integer> {
	
	@Query("SELECT b FROM Booking b WHERE b.user.id =:userId ORDER BY b.bookingId DESC")
	public List<Booking> getByUserId(@Param("userId") int userId);
}
