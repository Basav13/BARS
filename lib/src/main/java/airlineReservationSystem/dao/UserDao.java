package airlineReservationSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import airlineReservationSystem.entities.User;

@Repository
@CrossOrigin("http://localhost:4200")
public interface UserDao extends JpaRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE u.email =:email AND u.password =:password")
	 User findByEmailAndPassword(@Param("email") String email,@Param("password") String password);
	
	@Query("SELECT u FROM User u WHERE u.id =:userId")
	User getUserById(@Param("userId") int userId);
	
	@Query("SELECT u.firstName FROM User u WHERE u.id =:userId")
	String getFirstName(@Param("userId") int userId);
}
