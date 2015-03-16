package pwr.itApp.customerStaff.domain.enums;

public enum EmplType implements EnumWithId{

	OWNER ("O", "emplType.owner"),
	WAITER ("W", "emplType.waiter"),
	BARMAN ("B", "emplType.barman"),
	COOKER ("C", "emplType.cooker"),
	CUSTOMER ("R", "emplType.customer");
	
	private String key;
	private String nameKey;
	
	private EmplType(String key, String nameKey) {
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
	
	public static EmplType fromString(String code) {
		for (EmplType type: EmplType.values()) {
			if (type.getId().equals(code)) {
				return type;
			}
		}
		
		return null;
	}
}
