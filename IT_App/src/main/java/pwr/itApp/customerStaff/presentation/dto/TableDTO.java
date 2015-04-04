package pwr.itApp.customerStaff.presentation.dto;


import pwr.itApp.customerStaff.presentation.components.ElementComponent;

public class TableDTO implements ElementComponent {

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "simple name";
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        sb.append("Simple description\n");
        sb.append("address");
        return sb.toString();
    }

    @Override
    public String getImageURL() {
        // TODO Auto-generated method stub
        return "images/table.gif";
    }
}
