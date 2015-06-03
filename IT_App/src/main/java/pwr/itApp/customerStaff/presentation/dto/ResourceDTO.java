package pwr.itApp.customerStaff.presentation.dto;

import java.io.Serializable;

import pwr.itApp.customerStaff.domain.enums.MeasureUnit;
import pwr.itApp.customerStaff.domain.enums.ResourceType;
import pwr.itApp.customerStaff.presentation.components.ElementComponent;

public class ResourceDTO implements ElementComponent, Serializable{

	private static final long serialVersionUID = -5864581131390559808L;
	private Integer id;
	private String name;
	private Double minimalAmount;
	private Double criticalAmount;
	private Double price;
	private Double amount;
	private MeasureUnit measureUnit;
	private ResourceType resourceType;
	private int restaurantId;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImageURL() {
		return measureUnit.getImageURL();
	}

	public void setName(String name) {
		this.name = name;
	}

	public MeasureUnit getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(MeasureUnit measureUnit) {
		this.measureUnit = measureUnit;
		setResourceType(measureUnit.getResourceType());
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isLiquid() {
		return measureUnit.isLiquid();
	}

	public boolean isWeightResource() {
		return measureUnit.isWeight();
	}

	public boolean isPieceResource() {
		return measureUnit.isPiece();
	}

	public Double getMinimalAmount() {
		return minimalAmount;
	}

	public void setMinimalAmount(Double minimalAmount) {
		this.minimalAmount = minimalAmount;
	}

	public Double getCriticalAmount() {
		return criticalAmount;
	}

	public void setCriticalAmount(Double criticalAmount) {
		this.criticalAmount = criticalAmount;
	}

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
		minimalAmount = ResourceType.getMinimalAmount(resourceType);
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResourceDTO other = (ResourceDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
