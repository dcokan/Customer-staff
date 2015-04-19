package pwr.itApp.customerStaff.presentation.dto.ordersDTO;

import pwr.itApp.customerStaff.presentation.components.ElementComponent;


public class DrinkDTO implements ElementComponent {

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "simple drink";
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        sb.append("Simple description\n");
        return sb.toString();
    }

    @Override
    public String getImageURL() {
        // TODO Auto-generated method stub
        return "images/drink.png";
    }
}
