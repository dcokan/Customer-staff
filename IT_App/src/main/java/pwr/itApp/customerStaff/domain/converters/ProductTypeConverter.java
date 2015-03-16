package pwr.itApp.customerStaff.domain.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import pwr.itApp.customerStaff.domain.enums.EnumsUtils;
import pwr.itApp.customerStaff.domain.enums.ProductType;

@Converter
public class ProductTypeConverter implements AttributeConverter<ProductType, String>{

	@Override
	public String convertToDatabaseColumn(ProductType type) {
		return type.getId();
	}

	@Override
	public ProductType convertToEntityAttribute(String code) {
		return EnumsUtils.fromString(ProductType.values(), code);
	}

}
