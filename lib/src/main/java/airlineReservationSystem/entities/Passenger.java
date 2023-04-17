package airlineReservationSystem.entities;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="tbl_passengers")
public class Passenger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int passId;
	@Column(name="first_name",nullable=false,length=50)
	private String firstName;
	@Column(name="last_name",nullable=false,length=50)
	private String lastName;
	@Column(name="birth_date",nullable=false,length=20)
	private String birthDate;
	@Column(name="gender",nullable=false,length=12)
	private String gender;
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="user_id",nullable=false)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	//@JoinTable(name="tbl_user",joinColumns=@JoinColumn(name="user_id"))
	//@OnDelete(action=OnDeleteAction.CASCADE)
	private User user;
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="category_id",nullable=false)
	//@JoinTable(name="tbl_fare_categories",joinColumns=@JoinColumn(name="category_id"))
	private FareCategories category;
	@Column(name="flight_date")
	private String flightDate;
	@Column(name="flight_id")
	private int flightId;
	@Column(name="booking_amount")
	private BigDecimal bookingAmount;
	
public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	//	public int getCategory() {
//		return categoryId;
//	}
//	public void setCategory(int categoryId) {
//		this.categoryId = categoryId;
//	}
	
	
	public int getPassId() {
		return passId;
	}
	public BigDecimal getBookingAmount() {
		return bookingAmount;
	}
	public void setBookingAmount(BigDecimal bookingAmount) {
		this.bookingAmount = bookingAmount;
	}
	public void setPassId(int passId) {
		this.passId = passId;
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
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
	
	public Passenger() {
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public FareCategories getCategory() {
		return category;
	}
	public void setCategory(FareCategories category) {
		this.category = category;
	}
	public Passenger(String firstName, String lastName, String birthDate, String gender, User user,
			FareCategories category , String flightDate, int flightId ,BigDecimal bookingAmount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.user = user;
		this.category = category;
		this.flightDate = flightDate;
		this.flightId = flightId;
		this.bookingAmount = bookingAmount;
	}
	
//	public Passenger( String firstName, String lastName, String birthDate, String gender, int userId,
//			int categoryId) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.birthDate = birthDate;
//		this.gender = gender;
//		this.userId = userId;
//		this.categoryId = categoryId;
//	}
	
	
	
	
}
