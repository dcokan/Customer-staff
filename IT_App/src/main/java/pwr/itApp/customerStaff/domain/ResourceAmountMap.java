package pwr.itApp.customerStaff.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_RESOURCES_MAP")
public class ResourceAmountMap {

	@Id
	private int id;
	
	private double amount;

    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private Resource resource;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
}
