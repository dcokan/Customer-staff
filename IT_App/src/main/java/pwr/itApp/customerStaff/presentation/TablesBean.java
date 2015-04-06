package pwr.itApp.customerStaff.presentation;


import org.springframework.stereotype.Component;
import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.OrderDTO;
import pwr.itApp.customerStaff.presentation.dto.RestaurantDTO;
import pwr.itApp.customerStaff.presentation.dto.TableDTO;

import java.util.ArrayList;
import java.util.List;

@Component("tablesBean")
public class TablesBean implements ElementsList<TableDTO> {

    @Override
    public List<TableDTO> getValueList() {
        // TODO Auto-generated method stub
        List<TableDTO> tables = new ArrayList<TableDTO>();
        tables.add(new TableDTO());
        return tables;
    }
}
