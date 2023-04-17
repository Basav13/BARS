package airlineReservationSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_routes")
public class Routes {
	
	@Id
	@Column(name="route_id",nullable=false,unique=true)
	private int routeId;
	@Column(name="source_id",nullable=false)
	private int sourceId;
	@Column(name="dest_id",nullable=false)
	private int destId;
	@Column(name="distance",nullable=false)
	private int distance;
	@Column(name="base_fare",nullable=false)
	private int baseFare;
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getSourceId() {
		return sourceId;
	}
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	public int getDestId() {
		return destId;
	}
	public void setDestId(int destId) {
		this.destId = destId;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getBaseFare() {
		return baseFare;
	}
	public void setBaseFare(int baseFare) {
		this.baseFare = baseFare;
	}
	
	public Routes() {
		
	}
	
	public Routes(int routeId, int sourceId, int destId, int distance, int baseFare) {
		super();
		this.routeId = routeId;
		this.sourceId = sourceId;
		this.destId = destId;
		this.distance = distance;
		this.baseFare = baseFare;
	}
	
	
}
