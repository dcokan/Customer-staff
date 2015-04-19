package pwr.itApp.customerStaff.presentation.orderBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.ordersDTO.DessertDTO;
import pwr.itApp.customerStaff.webapp.login.Actor;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="dessertsBean")
@Scope("view")
public class DessertBean implements ElementsList<DessertDTO>, Serializable {

    @Autowired
    private Actor actor;

    private List<DessertDTO> dessertsList;
    private DessertDTO selectedSessert;
    private DessertDTO newDessert;
    private boolean newDessertAddMode;

    @Override
    public List<DessertDTO> getValueList() {
        // TODO Auto-generated method stub
        List<DessertDTO> desserts = new ArrayList<DessertDTO>();
        desserts.add(new DessertDTO());
        return desserts;
    }


    @Override
    public void onNewItemButton() {
        newDessertAddMode = true;
        selectedSessert = null;
    }

    @Override
    public void onDeailShowButton(DessertDTO item) {
        selectedSessert = item;
        newDessertAddMode = false;
    }

    public boolean isNewDessertAddMode() {
        return newDessertAddMode;
    }

    public void setNewDessertAddMode(boolean newDessertAddMode) {
        this.newDessertAddMode = newDessertAddMode;
    }

    public DessertDTO getNewDessert() {
        return newDessert;
    }

    public void setNewDessert(DessertDTO newDessert) {
        this.newDessert = newDessert;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public List<DessertDTO> getDessertsList() {
        return dessertsList;
    }

    public void setDessertsList(List<DessertDTO> dessertsList) {
        this.dessertsList = dessertsList;
    }

    public DessertDTO getSelectedSessert() {
        return selectedSessert;
    }

    public void setSelectedSessert(DessertDTO selectedSessert) {
        this.selectedSessert = selectedSessert;
    }
}
