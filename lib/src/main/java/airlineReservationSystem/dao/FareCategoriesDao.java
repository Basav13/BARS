package airlineReservationSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import airlineReservationSystem.entities.FareCategories;

@Repository
@CrossOrigin("http://localhost:4200")
public interface FareCategoriesDao extends JpaRepository<FareCategories, Integer> {
		
		@Query("SELECT c FROM FareCategories c WHERE c.categoryId =:catId")
		public FareCategories getByCategoryId(@Param("catId") int catId);
}
