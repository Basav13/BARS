package airlineReservationSystem.dao;

import java.time.LocalTime;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import airlineReservationSystem.entities.Flight;


@Repository
@CrossOrigin("http://localhost:4200")
public interface FlightDao extends JpaRepository<Flight,Integer> {
	
//	@Query("SELECT f.flightId, f.planes.planeId, f.routes.sourceId, f.routes.destId, f.flightSlots.slotFrom,  f.flightSlots.slotTo, f.routes.baseFare, f.seats "
//			+ "From Flight f "
//			+ "WHERE f.routes.sourceId = :sourceId AND f.routes.destId = :destId "
//			+ "ORDER BY \r\n"
//			+ "    CASE\r\n"
//			+ "        WHEN :sortField IS NOT NULL AND :sortField = 'slotFrom' THEN f.flightSlots.slotFrom\r\n"
//			+ "        WHEN :sortField IS NOT NULL AND :sortField = 'slotTo' THEN f.flightSlots.slotTo\r\n"
//			+ "        ELSE NULL\r\n"
//			+ "    END ASC")
//	public List<Object[]> findFlights(@Param("sourceId") int sourceId,@Param("destId") int destId, @Param("sortField") String sortField);
	
	@Query("SELECT f.flightId, f.planes.planeId, f.routes.sourceId, f.routes.destId, f.flightSlots.slotFrom, f.flightSlots.slotTo, f.routes.baseFare, f.seats "
	        + "FROM Flight f "
	        + "WHERE f.routes.sourceId = :sourceId AND f.routes.destId = :destId "
	        + "ORDER BY \r\n"
	        + "    CASE\r\n"
	        + "        WHEN :sortField IS NOT NULL AND :sortField = 'slotFrom' THEN (EXTRACT(EPOCH FROM f.flightSlots.slotFrom) * 1000)\r\n"
	        + "        WHEN :sortField IS NOT NULL AND :sortField = 'slotTo' THEN (EXTRACT(EPOCH FROM f.flightSlots.slotTo)* 1000)\r\n"
	        + "        WHEN :sortField IS NOT NULL AND :sortField = 'fare' THEN f.routes.baseFare\r\n"
	        + "        ELSE NULL\r\n"
	        + "    END ASC, f.routes.baseFare ASC")
	public List<Object[]> findFlights(@Param("sourceId") int sourceId, @Param("destId") int destId, @Param("sortField") String sortField);






	
	@Query("SELECT f.flightId FROM Flight f WHERE f.planes.planeId = :planeId AND f.routes.sourceId = :sourceId AND f.routes.destId = :destId AND f.flightSlots.slotFrom = :slotFrom AND f.flightSlots.slotTo = :slotTo")
	  int findFlightIdByPlaneIdAndSourceIdAndDestIdAndSlotFromAndSlotTo(
	    @Param("planeId") String planeId, 
	    @Param("sourceId") int sourceId, 
	    @Param("destId") int destId, 
	    @Param("slotFrom") LocalTime slotFrom, 
	    @Param("slotTo") LocalTime slotTo
	  );
	
}
