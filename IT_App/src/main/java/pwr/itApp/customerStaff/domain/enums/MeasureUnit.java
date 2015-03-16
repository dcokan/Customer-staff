package pwr.itApp.customerStaff.domain.enums;

public enum MeasureUnit implements EnumWithId{
	
	GRAM ("G", "measureUnit.g"),
	KILOGRAM ("KG", "measureUnit.kg"),
	MILILITER ("ML", "measureUnit.ml"),
	LITER ("L", "measureUnit.l"),
	PIECE ("PC", "measureUnit.pc");
	
	private String key; 
	private String nameKey;
	
	private MeasureUnit(String key, String nameKey) {
		this.key = key;
		this.nameKey = nameKey;
	}

	@Override
	public String getId() {
		return key;
	}
	
	public String getNameKey() {
		return nameKey;
	}

}
