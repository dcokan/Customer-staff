package pwr.itApp.customerStaff.domain.enums;

public enum MeasureUnit implements EnumWithId{
	
	GRAM ("G", "measureUnit.g", ResourceType.WEIGHT),
	KILOGRAM ("KG", "measureUnit.kg", ResourceType.WEIGHT),
	MILILITER ("ML", "measureUnit.ml", ResourceType.LIQUID),
	LITER ("L", "measureUnit.l", ResourceType.LIQUID),
	PIECE ("PC", "measureUnit.pc", ResourceType.PIECE);
	
	private String key; 
	private String nameKey;
	private ResourceType resourceType;
	
	private MeasureUnit(String key, String nameKey, ResourceType resourceType) {
		this.key = key;
		this.nameKey = nameKey;
		this.resourceType = resourceType;
	}

	@Override
	public String getId() {
		return key;
	}
	
	public String getNameKey() {
		return nameKey;
	}

	private boolean isTypeOf(ResourceType type) {
		return resourceType.equals(type); 
	}
	
	public boolean isLiquid() {
		return isTypeOf(ResourceType.LIQUID);
	}


	public boolean isWeight() {
		return isTypeOf(ResourceType.WEIGHT);
	}

	public boolean isPiece() {
		return isTypeOf(ResourceType.PIECE);
	}

	public String getImageURL() {
		if (isLiquid()) {
			return "images/liquidRes.png";
		} else if (isWeight()) {
			return "images/weightRes.png";
		} else if (isPiece()) {
			return "images/pieceRes.png";
		} else {
			throw new UnsupportedOperationException("Not supported MeasueUnit");
		}
	}

}
