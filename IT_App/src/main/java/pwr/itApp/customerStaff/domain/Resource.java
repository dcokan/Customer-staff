package pwr.itApp.customerStaff.domain;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import pwr.itApp.customerStaff.domain.converters.MeasureUnitConverter;
import pwr.itApp.customerStaff.domain.enums.MeasureUnit;

@Entity
@Table(name = "RESOURCES")
@NamedQueries(
		@NamedQuery(name="Resource.findAllOfRest",
				query = "SELECT r FROM Resource r WHERE "
						+ "r.restaurantId = :restaurantId"))
public class Resource {

	@Id
	private int id;
	
	private String name;
	
	@Convert(converter = MeasureUnitConverter.class)
	@Column(name = "MEAS_UNIT")
	private MeasureUnit measureUnit;
	
	private double amount;
	
	private double price;
	
	@Column(name="RESTAURANT_ID")
	private int restaurantId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MeasureUnit getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(MeasureUnit measureUnit) {
		this.measureUnit = measureUnit;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
}
