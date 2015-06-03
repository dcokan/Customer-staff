package pwr.itApp.customerStaff.domain.enums;

import java.io.Serializable;

public enum ResourceType implements Serializable{
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

	public static Double getMinimalAmount(ResourceType resourceType) {
		if (resourceType == null) {
			return null;
		}
		switch (resourceType) {
		case LIQUID: {
			return 0.01;
		}
		case PIECE: {
			return 1.0;
		}
		case WEIGHT: {
			return 0.01;
		}
		}
		return null;
	}
}
