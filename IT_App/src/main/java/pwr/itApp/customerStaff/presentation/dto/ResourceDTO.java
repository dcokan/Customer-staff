package pwr.itApp.customerStaff.presentation.dto;

import pwr.itApp.customerStaff.domain.enums.MeasureUnit;
import pwr.itApp.customerStaff.domain.enums.ResourceType;
import pwr.itApp.customerStaff.presentation.components.ElementComponent;

public class ResourceDTO implements ElementComponent{
	
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
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
}
