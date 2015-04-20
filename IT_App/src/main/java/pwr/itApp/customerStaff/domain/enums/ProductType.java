package pwr.itApp.customerStaff.domain.enums;

import static pwr.itApp.customerStaff.webapp.TextResourceKeys.*;
public enum ProductType implements EnumWithId {

	ALCOHOL("A", ALCOHOL_KEY, FoodType.DRINK),
	COLD_DRINK("C", COLD_DRINK_KEY, FoodType.DRINK),
	HOT_DRINK("H", HOT_DRINK_KEY, FoodType.DRINK),
	MEAT("M", MEAT_KEY, FoodType.MEALS),
	SOUPES("S", SOUPES_KEY, FoodType.MEALS),
	FISH("F", FISH_KEY, FoodType.MEALS),
	DESSERTS("D", DESSERT_KEY,  FoodType.MEALS),
	APPETEIZER("E",APPETIZER_KEY ,FoodType.MEALS);
	
	private String key;
	private FoodType type;
	private String nameKey;
	
	private ProductType(String key, String nameKey, FoodType type) {
		this.key = key;
		this.type = type;
		this.nameKey = nameKey;
	}
	
	public String getNameKey() {
		return nameKey;
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

	public String getImageURL() {
		//TODO: Specify different img for every kind of product
		return "images/meal.png";
	}
}
