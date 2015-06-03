package pwr.itApp.customerStaff.domain.enums;

import static pwr.itApp.customerStaff.webapp.TextResourceKeys.*;
public enum ProductType implements EnumWithId {

	ALCOHOL("A", ALCOHOL_KEY, FoodType.DRINK, "Alcohol"),
	COLD_DRINK("C", COLD_DRINK_KEY, FoodType.DRINK, "Cold drinks"),
	HOT_DRINK("H", HOT_DRINK_KEY, FoodType.DRINK, "Hot drinks"),
	MEAT("M", MEAT_KEY, FoodType.MEALS, "Meat meals"),
	SOUPES("S", SOUPES_KEY, FoodType.MEALS, "Soups"),
	FISH("F", FISH_KEY, FoodType.MEALS, "Fish meals"),
	DESSERTS("D", DESSERT_KEY,  FoodType.MEALS, "Desserts"),
	APPETEIZER("E",APPETIZER_KEY ,FoodType.MEALS, "Appetizer");
	
	private String key;
	private FoodType type;
	private String nameKey;
	private String name;
	
	private ProductType(String key, String nameKey, FoodType type, String name) {
		this.key = key;
		this.type = type;
		this.nameKey = nameKey;
		this.name = name;
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

	public String getName() {
		return name;
	}
}
