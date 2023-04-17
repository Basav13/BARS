package airlineReservationSystem.services;

import java.util.List;

import airlineReservationSystem.entities.User;

public interface UserServices {
	
	public List<User> getUsers();
	public User getUser(int userId);
	public User addUser(User user);
	public User updateUser(User user);
	public void deleteUser(int userId);
	public User getByCredentials(String email, String password);
	public User getUserById(int userId);
	public String getFirstName(int userId);
}
