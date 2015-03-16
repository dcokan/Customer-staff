package pwr.itApp.customerStaff.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import pwr.itApp.customerStaff.domain.converters.OrderStatusConverter;
import pwr.itApp.customerStaff.domain.enums.OrderStatus;

@Entity
@javax.persistence.Table(name = "ORDERS")
public class Order {

	@Id
	private int id;
	
	@Column(name = "STATE")
	@Convert(converter = OrderStatusConverter.class)
	private OrderStatus status;
	
	private double price;
	
    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private Table table;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
}
