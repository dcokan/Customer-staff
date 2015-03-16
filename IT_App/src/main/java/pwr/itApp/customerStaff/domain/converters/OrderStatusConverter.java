package pwr.itApp.customerStaff.domain.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import pwr.itApp.customerStaff.domain.enums.EnumsUtils;
import pwr.itApp.customerStaff.domain.enums.OrderStatus;

@Converter
public class OrderStatusConverter implements AttributeConverter<OrderStatus, String>{

	@Override
	public String convertToDatabaseColumn(OrderStatus status) {
		return status.getId();
	}

	@Override
	public OrderStatus convertToEntityAttribute(String code) {
		return EnumsUtils.fromString(OrderStatus.values(), code);
	}

}
