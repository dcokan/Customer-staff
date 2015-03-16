package pwr.itApp.customerStaff.domain.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import pwr.itApp.customerStaff.domain.enums.EmplType;
import pwr.itApp.customerStaff.domain.enums.EnumsUtils;

@Converter
public class EmplTypeConverter implements AttributeConverter<EmplType, String>{

	@Override
	public String convertToDatabaseColumn(EmplType emplType) {
		return emplType.getId();
	}

	@Override
	public EmplType convertToEntityAttribute(String desc) {
		return EnumsUtils.fromString(EmplType.values(), desc);
	}


}
