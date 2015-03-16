package pwr.itApp.customerStaff.domain.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class YNBooleanConverter implements AttributeConverter<Boolean, String>{

	@Override
	public String convertToDatabaseColumn(Boolean state) {
		return state ? "Y" : "N";
	}

	@Override
	public Boolean convertToEntityAttribute(String booleanCode) {
		return new Boolean (booleanCode.equals("Y"));
	}

}
