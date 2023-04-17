package airlineReservationSystem.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_airports")
public class Airports {
	
	@Id
	@Column(name="airport_id",nullable=false,unique=true)
	private BigDecimal airportId;
	@Column(name="airport_code",nullable=false,length=5)
	private String airportCode;
	@Column(name="airport_name",nullable=false,length=10)
	private String airportName;
	public BigDecimal getAirportId() {
		return airportId;
	}
	public void setAirportId(BigDecimal airportId) {
		this.airportId = airportId;
	}
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	
	public Airports() {
		
	}
	public Airports(BigDecimal airportId, String airportCode, String airportName) {
		super();
		this.airportId = airportId;
		this.airportCode = airportCode;
		this.airportName = airportName;
	}
	
	

}
