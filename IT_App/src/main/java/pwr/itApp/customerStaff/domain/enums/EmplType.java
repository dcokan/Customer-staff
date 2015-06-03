package pwr.itApp.customerStaff.domain.enums;

public enum EmplType implements EnumWithId{

	OWNER ("O", "emplType.owner", "Owner"),
	WAITER ("W", "emplType.waiter", "Waiter"),
	BARMAN ("B", "emplType.barman", "Barman"),
	COOKER ("C", "emplType.cooker", "Cooker"),
	CUSTOMER ("R", "emplType.customer", "Customer");
	
	private String key;
	private String nameKey;
	private String name;
	
	private EmplType(String key, String nameKey, String name) {
		this.key = key;
		this.nameKey = nameKey;
		this.name = name;
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

	public String getName() {
		return name;
	}
}
