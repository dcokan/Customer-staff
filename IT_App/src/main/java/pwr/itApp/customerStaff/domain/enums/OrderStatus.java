package pwr.itApp.customerStaff.domain.enums;

public enum OrderStatus implements EnumWithId{

	INITIALIZED("I", "order.initialized"),
	PREPARED("P", "order.prepared"),
	READY_TO_SERVE("R", "order.readyToServe"),
	SERVED("S", "order.served"),
	COMPLETED("E", "order.end"),
	CANCELLED("C", "order.cancelled");
	
	private String key;
	private String nameKey;
	
	private OrderStatus(String key, String nameKey) {
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
