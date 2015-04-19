package pwr.itApp.customerStaff.presentation.dto.ordersDTO;

import pwr.itApp.customerStaff.presentation.components.ElementComponent;


public class MealDTO implements ElementComponent {

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "simple meal";
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
        return "images/meal.png";
    }
}
