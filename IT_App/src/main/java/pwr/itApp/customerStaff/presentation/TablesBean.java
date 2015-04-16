package pwr.itApp.customerStaff.presentation;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.TableDTO;

@Component("tablesBean")
@Scope("view")
public class TablesBean implements ElementsList<TableDTO>, Serializable {
	private static final long serialVersionUID = 6838075698249515351L;

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
