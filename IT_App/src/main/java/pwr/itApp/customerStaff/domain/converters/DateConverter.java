package pwr.itApp.customerStaff.domain.converters;

import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.joda.time.DateTime;


@Converter
public class DateConverter implements AttributeConverter<DateTime, Date> {

	@Override
	public Date convertToDatabaseColumn(DateTime dt) {
		return dt.toDate();
	}

	@Override
	public DateTime convertToEntityAttribute(Date date) {
		return new DateTime(date);
	}

}
