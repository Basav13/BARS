package airlineReservationSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id",nullable=false,unique=true)
	private int id;
	@Column(name="first_name",nullable=false,length=50)
	private String firstName;
	@Column(name="last_name",nullable=false,length=50)
	private String lastName;
	@Column(name="birth_date",nullable=false,length=20)
	private String birthDate;
	@Column(name="gender",nullable=false,length=12)
	private String gender;
	@Column(name="email",nullable=false,length=50)
	private String email;
	@Column(name="password",nullable=false,length=50)
	private String password;
	@Column(name="status",length=15)
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String birthDate, String gender, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.email = email;
		this.password = password;
	}
	

}
