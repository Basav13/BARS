package airlineReservationSystem.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="tbl_bookings")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="booking_id",nullable=false,unique=true)
	private int bookingId;
	@Column(name="ref_no",nullable=false,length=10)
	private String refNo;
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private User user;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="flight_id",nullable=false)
	private Flight flight;
	@Column(name="flight_date",nullable=false)
	private LocalDate flightDate;
//	@Column(name="quantity",nullable=false)
//	private int quantity;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="category_id",nullable=false)
	private FareCategories fareCategory;
	@Column(name="amount",nullable=false)
	private BigDecimal amount;
	@Column(name="status",nullable=false)
	private String status;
	@Column(name="last_udpate_time",nullable=false)
	private LocalDateTime lastUpdateTime;
	@Column(name="f_name",length=20)
	private String fName;
	@Column(name="l_name",length=20)
	private String lName;
	
	
	

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public LocalDate getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}
//	public int getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
	public FareCategories getFareCategory() {
		return fareCategory;
	}
	public void setFareCategory(FareCategories fareCategory) {
		this.fareCategory = fareCategory;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	public Booking() {
		
	}
	
	public Booking(String refNo, User user, Flight flight, LocalDate flightDate, FareCategories fareCategory,
			BigDecimal amount, String status, LocalDateTime lastUpdateTime, String fName, String lName) {
		super();
		this.refNo = refNo;
		this.user = user;
		this.flight = flight;
		this.flightDate = flightDate;
		this.fareCategory = fareCategory;
		this.amount = amount;
		this.status = status;
		this.lastUpdateTime = lastUpdateTime;
		this.fName = fName;
		this.lName = lName;
	}
	
	
	
	
	
	

	
	
	

}
