package pwr.itApp.customerStaff.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.OrderDTO;
import pwr.itApp.customerStaff.presentation.dto.ResourceDTO;
import pwr.itApp.customerStaff.webapp.login.Actor;

@ManagedBean(name="ordersBean")
@ViewScoped
public class OrdersBean implements ElementsList<OrderDTO> {

	@Autowired
	private Actor actor;

    private List<OrderDTO> orderList;
    private OrderDTO selectedOrder;
    private OrderDTO newOrder;
    private boolean newOrderAddMode;
    private int activeTabIndex;

    @PostConstruct
    public void init() {
        activeTabIndex = 0;
        newOrder = new OrderDTO();
    }
	
    @Override
    public List<OrderDTO> getValueList() {
        // TODO Auto-generated method stub
        List<OrderDTO> orders = new ArrayList<OrderDTO>();
        orders.add(new OrderDTO());
        return orders;
    }

	@Override
	public void onNewItemButton() {
        newOrderAddMode = true;
        selectedOrder = null;
	}

	@Override
	public void onDeailShowButton(OrderDTO order) {
		selectedOrder = order;
        newOrderAddMode = false;
	}

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public List<OrderDTO> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDTO> orderList) {
        this.orderList = orderList;
    }

    public boolean isNewOrderAddMode() {
        return newOrderAddMode;
    }

    public void setNewOrderAddMode(boolean newOrderAddMode) {
        this.newOrderAddMode = newOrderAddMode;
    }

    public OrderDTO getNewOrder() {
        return newOrder;
    }

    public void setNewOrder(OrderDTO newOrder) {
        this.newOrder = newOrder;
    }

    public boolean isOrderSelected() {
        return selectedOrder != null;
    }
}
