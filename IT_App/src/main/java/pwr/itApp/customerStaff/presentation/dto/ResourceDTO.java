package pwr.itApp.customerStaff.presentation.dto;

import pwr.itApp.customerStaff.domain.enums.MeasureUnit;
import pwr.itApp.customerStaff.presentation.components.ElementComponent;

public class ResourceDTO implements ElementComponent{
	
	private String name;
	
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

	private MeasureUnit measureUnit;
	
	private double amount;
	
	private double price;

	public boolean isLiquid() {
		return measureUnit.isLiquid();
	}

	public boolean isWeightResource() {
		return measureUnit.isWeight();
	}

	public boolean isPieceResource() {
		return measureUnit.isPiece();
	}
}
