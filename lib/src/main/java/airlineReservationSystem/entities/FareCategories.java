package airlineReservationSystem.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_fare_categories")
public class FareCategories {
	
	@Id
	@Column(name="category_id",nullable=false,unique=true)
	private int categoryId;
	@Column(name="name",nullable=false,length=25)
	private String name;
	@Column(name="discount_percent",nullable=false)
	private BigDecimal discountPercent;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	public FareCategories() {
		
	}
	public FareCategories(int categoryId, String name, BigDecimal discountPercent) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.discountPercent = discountPercent;
	}
	
	
}
