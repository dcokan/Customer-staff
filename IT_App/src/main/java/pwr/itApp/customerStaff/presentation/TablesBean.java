package pwr.itApp.customerStaff.presentation;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.TableDTO;

@ManagedBean(name="tablesBean")
public class TablesBean implements ElementsList<TableDTO> {

    @Override
    public List<TableDTO> getValueList() {
        // TODO Auto-generated method stub
        List<TableDTO> tables = new ArrayList<TableDTO>();
        tables.add(new TableDTO());
        return tables;
    }

	@Override
	public void onNewItemButton() {
		throw new UnsupportedOperationException("New entry is not acceptable");
	}

	@Override
	public void onDeailShowButton(TableDTO item) {
		// TODO Auto-generated method stub
		
	}
}
