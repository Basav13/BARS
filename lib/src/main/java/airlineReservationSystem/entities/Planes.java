package airlineReservationSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="tbl_planes")
public class Planes {
	
	@Id
	@Column(name="plane_id",nullable=false,unique=true,length=12)
	private String planeId;
	@Column(name="status",nullable=false,length=10)
	private String status;
	@Column(name="seats",nullable=false)
	private BigDecimal seats;
	public String getPlaneId() {
		return planeId;
	}
	public void setPlaneId(String planeId) {
		this.planeId = planeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getSeats() {
		return seats;
	}
	public void setSeats(BigDecimal seats) {
		this.seats = seats;
	}
	
	public Planes() {
		
	}
	
	public Planes(String planeId, String status, BigDecimal seats) {
		super();
		this.planeId = planeId;
		this.status = status;
		this.seats = seats;
	}
	
	

}
