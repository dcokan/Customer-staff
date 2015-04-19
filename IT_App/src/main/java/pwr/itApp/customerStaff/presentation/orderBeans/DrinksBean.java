package pwr.itApp.customerStaff.presentation.orderBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.ordersDTO.DrinkDTO;
import pwr.itApp.customerStaff.webapp.login.Actor;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="drinksBean")
@Scope("view")
public class DrinksBean implements ElementsList<DrinkDTO>, Serializable {

    @Autowired
    private Actor actor;

    private List<DrinkDTO> drinksList;
    private DrinkDTO selectedDrink;
    private DrinkDTO newDrink;
    private boolean newDrinkAddMode;

    @Override
    public List<DrinkDTO> getValueList() {
        // TODO Auto-generated method stub
        List<DrinkDTO> drinks = new ArrayList<DrinkDTO>();
        drinks.add(new DrinkDTO());
        return drinks;
    }

    @Override
    public void onNewItemButton() {
        newDrinkAddMode = true;
        selectedDrink = null;
    }

    @Override
    public void onDeailShowButton(DrinkDTO item) {
        selectedDrink = item;
        newDrinkAddMode = false;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public List<DrinkDTO> getDrinksList() {
        return drinksList;
    }

    public void setDrinksList(List<DrinkDTO> drinksList) {
        this.drinksList = drinksList;
    }

    public DrinkDTO getSelectedDrink() {
        return selectedDrink;
    }

    public void setSelectedDrink(DrinkDTO selectedDrink) {
        this.selectedDrink = selectedDrink;
    }

    public DrinkDTO getNewDrink() {
        return newDrink;
    }

    public void setNewDrink(DrinkDTO newDrink) {
        this.newDrink = newDrink;
    }

    public boolean isNewDrinkAddMode() {
        return newDrinkAddMode;
    }

    public void setNewDrinkAddMode(boolean newDrinkAddMode) {
        this.newDrinkAddMode = newDrinkAddMode;
    }
}
