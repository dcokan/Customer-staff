package pwr.itApp.customerStaff.domain.enums;

public class EnumsUtils {

	public static <T extends EnumWithId> T fromString(T[] enums, String id) {
		for (T type: enums) {
			if (type.getId().equals(id)) {
				return type;
			}
		}
		
		return null;
	}
}
