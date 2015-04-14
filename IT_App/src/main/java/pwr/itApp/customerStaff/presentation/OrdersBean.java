package pwr.itApp.customerStaff.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.OrderDTO;
import pwr.itApp.customerStaff.webapp.login.Actor;

@ManagedBean(name="ordersBean")
@ViewScoped
public class OrdersBean implements ElementsList<OrderDTO> {

	@Autowired
	private Actor actor;
	
    @Override
    public List<OrderDTO> getValueList() {
        // TODO Auto-generated method stub
        List<OrderDTO> orders = new ArrayList<OrderDTO>();
        orders.add(new OrderDTO());
        return orders;
    }

	@Override
	public void onNewItemButton() {
		throw new UnsupportedOperationException("New entry is not acceptable");
	}

	@Override
	public void onDeailShowButton(OrderDTO item) {
		// TODO Auto-generated method stub
		
	}
	
}
