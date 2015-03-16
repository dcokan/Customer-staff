package pwr.itApp.customerStaff.domain.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import pwr.itApp.customerStaff.domain.enums.EmplType;

@Converter
public class EmplTypeConverter implements AttributeConverter<EmplType, String>{

	@Override
	public String convertToDatabaseColumn(EmplType emplType) {
		return emplType.getId();
	}

	@Override
	public EmplType convertToEntityAttribute(String desc) {
		for (EmplType type: EmplType.values()) {
			if (type.getId().equals(desc)) {
				return type;
			}
		}
		
		return null;
	}


}
