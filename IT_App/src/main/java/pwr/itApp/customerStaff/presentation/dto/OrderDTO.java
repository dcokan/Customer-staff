package pwr.itApp.customerStaff.presentation.dto;


import pwr.itApp.customerStaff.presentation.components.ElementComponent;

public class OrderDTO implements ElementComponent {

    private String name;
    private int tableNumber;

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "simple order";
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
        return "images/order1.png";
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}
