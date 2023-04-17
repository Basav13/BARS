package airlineReservationSystem.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_flights")
public class Flight {
	
	@Id
	@Column(name="flight_id",nullable=false,unique=true)
	private int flightId;
	@ManyToOne(fetch=FetchType.EAGER,optional=false,cascade=CascadeType.ALL)
	@JoinColumn(name="plane_id",nullable=false)
	private Planes planes;
	@ManyToOne(fetch=FetchType.EAGER,optional=false,cascade=CascadeType.ALL)
	@JoinColumn(name="route_id",nullable=false)
	private Routes routes;
	@ManyToOne(fetch=FetchType.EAGER,optional=false,cascade=CascadeType.ALL)
	@JoinColumn(name="slot_id",nullable=false,referencedColumnName="slot_id")
	private FlightSlots flightSlots;
	@Column(name="seats")
	private int seats;
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public Planes getPlanes() {
		return planes;
	}
	public void setPlanes(Planes planes) {
		this.planes = planes;
	}
	public Routes getRoutes() {
		return routes;
	}
	public void setRoutes(Routes routes) {
		this.routes = routes;
	}
	public FlightSlots getFlightSlots() {
		return flightSlots;
	}
	public void setFlightSlots(FlightSlots flightSlots) {
		this.flightSlots = flightSlots;
	}
	
	public Flight() {
		
	}
	public Flight(int flightId, Planes planes, Routes routes, FlightSlots flightSlots, int seats) {
		super();
		this.flightId = flightId;
		this.planes = planes;
		this.routes = routes;
		this.flightSlots = flightSlots;
		this.seats = seats;
	}
	
	
}
