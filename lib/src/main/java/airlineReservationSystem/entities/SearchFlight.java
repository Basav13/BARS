package airlineReservationSystem.entities;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SearchFlight {
	
	@Id
	@GeneratedValue
	private int id;
	private String planeId;
	private int sourceId;
	private int destId;
	private LocalTime slotFrom;
	private LocalTime slotTo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaneId() {
		return planeId;
	}
	public void setPlaneId(String planeId) {
		this.planeId = planeId;
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
	public LocalTime getSlotFrom() {
		return slotFrom;
	}
	public void setSlotFrom(LocalTime slotFrom) {
		this.slotFrom = slotFrom;
	}
	public LocalTime getSlotTo() {
		return slotTo;
	}
	public void setSlotTo(LocalTime slotTo) {
		this.slotTo = slotTo;
	}
	
	public SearchFlight() {
		
	}
	public SearchFlight(String planeId, int sourceId, int destId, LocalTime slotFrom, LocalTime slotTo) {
		super();
		this.planeId = planeId;
		this.sourceId = sourceId;
		this.destId = destId;
		this.slotFrom = slotFrom;
		this.slotTo = slotTo;
	}
	
	
}
