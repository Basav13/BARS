package airlineReservationSystem.controller;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import airlineReservationSystem.entities.User;
import airlineReservationSystem.services.UserServices;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserServices userServices;

	
	@GetMapping("/home")
	public String home() {
		return "this is home page";
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return this.userServices.getUsers();	
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable String userId) {
		return this.userServices.getUser(Integer.parseInt(userId));
	}
	
	@GetMapping("/user-profile")
	public ResponseEntity<User> getUserProfile(@RequestParam("userId") int userId) {
		User user = userServices.getUserById(userId);
        if (user != null) {
            try {
                return ResponseEntity.ok(user);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	
	
	@PostMapping(path="/user",consumes="application/json")
	public ResponseEntity<HttpStatus> addUser(@RequestBody User user) {
		
		try {
			this.userServices.addUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path="/user/update",consumes="application/json")
	public User updateUser(@RequestBody User user) {
		return this.userServices.updateUser(user);
	}
	
	@DeleteMapping("/user/delete/{userId}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId){
		try {
			this.userServices.deleteUser(Integer.parseInt(userId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/user/login")
	public User loginUser(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		User user = this.userServices.getByCredentials(email, password);
		if(!user.getStatus().equals("ACTIVE"))
			return null;
		return user;
	}
	
	@GetMapping("/user/first-name")
	public String getFirstName(@RequestParam("userId") int userId) {
		return this.userServices.getFirstName(userId);
	}
	
	
}
	
