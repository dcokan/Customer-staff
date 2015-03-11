package pwr.itApp.customerStaff.domain.enums;

public enum ProductType implements EnumWithId {

	ALCOHOL("A", FoodType.DRINK),
	COLD_DRINK("C", FoodType.DRINK),
	HOT_DRINK("H", FoodType.DRINK),
	MEAT("M", FoodType.MEALS),
	SOUPES("S", FoodType.MEALS),
	FISH("F", FoodType.MEALS),
	DESERTS("D", FoodType.MEALS),
	APPETEIZER("E", FoodType.MEALS);
	
	private String key;
	private FoodType type;
	
	private ProductType(String key, FoodType type) {
		this.key = key;
		this.type = type;
	}
	
	@Override
	public String getId() {
		return key;
	}
	
	public FoodType getType() {
		return type;
	}

	public enum FoodType {
		DRINK,
		MEALS;
	}
}
