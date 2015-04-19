package pwr.itApp.customerStaff.presentation.orderBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.ordersDTO.MealDTO;
import pwr.itApp.customerStaff.webapp.login.Actor;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="mealsBean")
@Scope("view")
public class MealsBean implements ElementsList<MealDTO>, Serializable {

    @Autowired
    private Actor actor;

    private List<MealDTO> mealsList;
    private MealDTO selectedMeal;
    private MealDTO newMeal;
    private boolean newMealAddMode;

    @Override
    public List<MealDTO> getValueList() {
        // TODO Auto-generated method stub
        List<MealDTO> meals = new ArrayList<MealDTO>();
        meals.add(new MealDTO());
        return meals;
    }

    @Override
    public void onNewItemButton() {
        newMealAddMode = true;
        selectedMeal = null;
    }

    @Override
    public void onDeailShowButton(MealDTO item) {
        selectedMeal = item;
        newMealAddMode = false;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public List<MealDTO> getMealsList() {
        return mealsList;
    }

    public void setMealsList(List<MealDTO> mealsList) {
        this.mealsList = mealsList;
    }

    public MealDTO getSelectedMeal() {
        return selectedMeal;
    }

    public void setSelectedMeal(MealDTO selectedMeal) {
        this.selectedMeal = selectedMeal;
    }

    public MealDTO getNewMeal() {
        return newMeal;
    }

    public void setNewMeal(MealDTO newMeal) {
        this.newMeal = newMeal;
    }

    public boolean isNewMealAddMode() {
        return newMealAddMode;
    }

    public void setNewMealAddMode(boolean newMealAddMode) {
        this.newMealAddMode = newMealAddMode;
    }
}
