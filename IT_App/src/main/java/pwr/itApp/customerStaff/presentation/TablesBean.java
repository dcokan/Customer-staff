package pwr.itApp.customerStaff.presentation;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.TableDTO;

@Component("tablesBean")
public class TablesBean implements ElementsList<TableDTO> {

    @Override
    public List<TableDTO> getValueList() {
        // TODO Auto-generated method stub
        List<TableDTO> tables = new ArrayList<TableDTO>();
        tables.add(new TableDTO());
        return tables;
    }

	@Override
	public String onNewItemButton() {
		throw new UnsupportedOperationException("New entry is not acceptable");
	}
}
