package airlineReservationSystem.entities;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_flight_slots")
public class FlightSlots {
	
	@Id
	@Column(name="slot_id",nullable=false,unique=true)
	private int slotId;
	@Column(name="slot_from",nullable=false)
	private LocalTime slotFrom;
	@Column(name="slot_to",nullable=false)
	private LocalTime slotTo;
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
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
	
	public FlightSlots() {
		
	}
	public FlightSlots(int slotId, LocalTime slotFrom, LocalTime slotTo) {
		super();
		this.slotId = slotId;
		this.slotFrom = slotFrom;
		this.slotTo = slotTo;
	}
	
	
}
