package pwr.itApp.customerStaff.domain;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.joda.time.DateTime;

import pwr.itApp.customerStaff.domain.converters.DateConverter;
import pwr.itApp.customerStaff.domain.converters.YNBooleanConverter;

@javax.persistence.Table(name = "TABLES")
@Entity
public class Table {

	@Id
	private int id;
	
	private String name;
	
	private int limit;
	
	@Convert(converter = DateConverter.class)
	@Column(name = "RESERVATION_DATE")
	private DateTime reservationDate;
	
	@Convert(converter = YNBooleanConverter.class)
	private boolean vip;
	
	@Convert(converter = YNBooleanConverter.class)
	private boolean deleted;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public DateTime getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(DateTime reservationDate) {
		this.reservationDate = reservationDate;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
