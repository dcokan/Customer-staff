package pwr.itApp.customerStaff.persistance;



import org.springframework.stereotype.Repository;

import pwr.itApp.customerStaff.domain.Order;

@Repository
public class OrderDAO extends GenericDAO<Order>{

	public Order find(int id) {
		return em.find(Order.class, id);
	}
}
