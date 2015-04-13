package pwr.itApp.customerStaff.domain.enums;

public enum MeasureUnit implements EnumWithId{
	
	GRAM ("G", "measureUnit.g", false, true, false),
	KILOGRAM ("KG", "measureUnit.kg", false, true, false),
	MILILITER ("ML", "measureUnit.ml", true, false, false),
	LITER ("L", "measureUnit.l", true, false, false),
	PIECE ("PC", "measureUnit.pc", false, false, true);
	
	private String key; 
	private String nameKey;
	private boolean liquid;
	private boolean weight;
	private boolean piece;
	
	private MeasureUnit(String key, String nameKey, boolean liquid, 
				boolean weight, boolean piece) {
		this.key = key;
		this.nameKey = nameKey;
		this.liquid = liquid;
		this.weight = weight;
		this.piece = piece;
	}

	@Override
	public String getId() {
		return key;
	}
	
	public String getNameKey() {
		return nameKey;
	}

	public boolean isLiquid() {
		return liquid;
	}

	public boolean isWeight() {
		return weight;
	}

	public boolean isPiece() {
		return piece;
	}

	public String getImageURL() {
		if (liquid) {
			return "images/liquidRes.png";
		} else if (weight) {
			return "images/weightRes.png";
		} else if (piece) {
			return "images/pieceRes.png";
		} else {
			throw new UnsupportedOperationException("Not supported MeasueUnit");
		}
	}

}
