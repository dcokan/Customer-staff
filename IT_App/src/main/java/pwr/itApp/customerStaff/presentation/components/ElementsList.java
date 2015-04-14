package pwr.itApp.customerStaff.presentation.components;

import java.util.List;

public interface ElementsList<T extends ElementComponent> {

	public List<T> getValueList();
	public void onNewItemButton();
	public void onDeailShowButton(T item);
}
