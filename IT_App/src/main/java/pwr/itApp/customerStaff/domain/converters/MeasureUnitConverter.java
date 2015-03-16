package pwr.itApp.customerStaff.domain.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import pwr.itApp.customerStaff.domain.enums.EnumsUtils;
import pwr.itApp.customerStaff.domain.enums.MeasureUnit;

@Converter
public class MeasureUnitConverter implements AttributeConverter<MeasureUnit, String>{

	@Override
	public String convertToDatabaseColumn(MeasureUnit unit) {
		return unit.getId();
	}

	@Override
	public MeasureUnit convertToEntityAttribute(String code) {
		return EnumsUtils.fromString(MeasureUnit.values(), code);
	}

}
