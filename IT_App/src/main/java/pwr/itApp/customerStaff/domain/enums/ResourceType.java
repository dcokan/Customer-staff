package pwr.itApp.customerStaff.domain.enums;

public enum ResourceType {
	LIQUID("resourceType.liquid"),
	WEIGHT("resourceType.weight"),
	PIECE("resourceType.piece");
	
	private String nameKey;

	private ResourceType(String nameKey) {
		this.nameKey = nameKey;
	}

	public String getNameKey() {
		return nameKey;
	}

	public void setNameKey(String nameKey) {
		this.nameKey = nameKey;
	}
}
