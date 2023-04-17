package airlineReservationSystem.services;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airlineReservationSystem.dao.UserDao;
import airlineReservationSystem.entities.User;

@Service
public class UserServicesImp implements UserServices {
	
	@Autowired 
	private UserDao userDao;
	
	public UserServicesImp() {
		
	}
	
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		Optional<User> usr = userDao.findById(userId);
		User user = usr.get();
		return user;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		user.setStatus("ACTIVE");
		userDao.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
		return user;
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
//		Optional<User> usr = userDao.findById(userId);
//		User user = usr.get();
//		userDao.delete(user);
//		System.out.println(userId);
		Optional<User> usr = this.userDao.findById(userId);
		User user = usr.get();
		user.setStatus("DEACTIVE");
		this.userDao.save(user);
	}

	@Override
	public User getByCredentials(String email, String password) {
	    return userDao.findByEmailAndPassword(email, password);
	  }

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userDao.getUserById(userId);
	}

	@Override
	public String getFirstName(int userId) {
		// TODO Auto-generated method stub
		Optional<User> usr = this.userDao.findById(userId);
		User user = usr.get();
		
		return user.getFirstName();
	}
	
	

}
