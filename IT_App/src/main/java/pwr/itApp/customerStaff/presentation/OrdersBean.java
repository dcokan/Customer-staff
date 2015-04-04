package pwr.itApp.customerStaff.presentation;

import org.springframework.stereotype.Component;
import pwr.itApp.customerStaff.presentation.dto.OrderDTO;
import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.RestaurantDTO;

import java.util.ArrayList;
import java.util.List;

@Component("ordersBean")
public class OrdersBean implements ElementsList<OrderDTO> {

    @Override
    public List<OrderDTO> getValueList() {
        // TODO Auto-generated method stub
        List<OrderDTO> orders = new ArrayList<OrderDTO>();
        orders.add(new OrderDTO());
        return orders;
    }
}
