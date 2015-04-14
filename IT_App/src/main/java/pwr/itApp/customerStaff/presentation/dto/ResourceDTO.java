package pwr.itApp.customerStaff.presentation.dto;

import pwr.itApp.customerStaff.domain.enums.MeasureUnit;
import pwr.itApp.customerStaff.presentation.components.ElementComponent;

public class ResourceDTO implements ElementComponent{
	
	private String name;
	private double minimalAmount;
	private double criticalAmount;
	private double price;
	private double amount;
	private MeasureUnit measureUnit;
	
	
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

	public boolean isLiquid() {
		return measureUnit.isLiquid();
	}

	public boolean isWeightResource() {
		return measureUnit.isWeight();
	}

	public boolean isPieceResource() {
		return measureUnit.isPiece();
	}

	public double getMinimalAmount() {
		return minimalAmount;
	}

	public void setMinimalAmount(double minimalAmount) {
		this.minimalAmount = minimalAmount;
	}

	public double getCriticalAmount() {
		return criticalAmount;
	}

	public void setCriticalAmount(double criticalAmount) {
		this.criticalAmount = criticalAmount;
	}
}
