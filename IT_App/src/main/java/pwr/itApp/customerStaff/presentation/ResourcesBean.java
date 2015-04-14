package pwr.itApp.customerStaff.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.ResourceDTO;
import pwr.itApp.customerStaff.service.ResourcesService;
import pwr.itApp.customerStaff.webapp.login.Actor;

@Component("resourcesBean")
@ViewScoped
public class ResourcesBean implements ElementsList<ResourceDTO>{

	@Autowired
	private Actor actor;
	
	@Autowired
	private ResourcesService resourcesService;
	
	private List<ResourceDTO> liquidResources;
	private List<ResourceDTO> gramResources;
	private List<ResourceDTO> pieceResources;
	private ResourceDTO selectedResource;
	private ResourceDTO newResource;
	private boolean newResourceAddMode;
	private boolean minimalAmountDialogShown;
	private int activeTabIndex;
	
	@PostConstruct
	public void init() {
		activeTabIndex = 0;
		newResource = new ResourceDTO();
	}
	
	public List<ResourceDTO> getLiquidResources() {
		if (liquidResources == null) {
			initResources();
		}
		
		return liquidResources;
	}
	
	public List<ResourceDTO> getGramResources() {
		if (gramResources == null) {
			initResources();
		}
		
		return gramResources;
	}
	
	public List<ResourceDTO> getPieceResources() {
		if (pieceResources == null) {
			initResources();
		}
		
		return pieceResources;
	}

	@Override
	public void onNewItemButton() {
		newResourceAddMode = true;
		selectedResource = null;
	}
	
	public void onNewMinimalAmountConfirm() {
		minimalAmountDialogShown = false;
	}
	
	public void changeMinimalAmountDialogVisibility() {
		minimalAmountDialogShown = !minimalAmountDialogShown;
	}
	
	private void initResources() {
		List<ResourceDTO> allResources = resourcesService.getAllRestaurantResources(
				actor.getChosenRestaurantId());
		liquidResources = new ArrayList<ResourceDTO>();
		gramResources = new ArrayList<ResourceDTO>();
		pieceResources = new ArrayList<ResourceDTO>();
		
		for (ResourceDTO res: allResources) {
			if (res.isLiquid()) {
				liquidResources.add(res);
			} else if (res.isWeightResource()) {
				gramResources.add(res);
			} else if (res.isPieceResource()) {
				pieceResources.add(res);
			}
		}
	}

	@Override
	public List<ResourceDTO> getValueList() {
//		throw new UnsupportedOperationException("Bean doesn't support this operation");
		return null;
	}

	@Override
	public void onDeailShowButton(ResourceDTO resource) {
		selectedResource = resource;
		newResourceAddMode = false;
	}

	public String getPriceLabel() {
		//TODO: It should return shomething like:
		// "price for 1 ml"
		// However if user set minimal amount lowet then sjhould be this used
		return "TEMP";
	}
	
	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public ResourcesService getResourcesService() {
		return resourcesService;
	}

	public void setResourcesService(ResourcesService resourcesService) {
		this.resourcesService = resourcesService;
	}

	public ResourceDTO getSelectedResource() {
		return selectedResource;
	}

	public void setSelectedResource(ResourceDTO selectedResource) {
		this.selectedResource = selectedResource;
	}

	public void setLiquidResources(List<ResourceDTO> liquidResources) {
		this.liquidResources = liquidResources;
	}

	public void setGramResources(List<ResourceDTO> gramResources) {
		this.gramResources = gramResources;
	}

	public void setPieceResources(List<ResourceDTO> pieceResources) {
		this.pieceResources = pieceResources;
	}
	
	public boolean isResourceSelected() {
		return selectedResource != null;
	}

	public boolean isNewResourceAddMode() {
		return newResourceAddMode;
	}

	public boolean isMinimalAmountDialogShown() {
		return minimalAmountDialogShown;
	}
	
	public boolean canEditMinimalAmount() {
		return !newResource.getMeasureUnit().isPiece();
	}

	public int getActiveTabIndex() {
		return activeTabIndex;
	}

	public void setActiveTabIndex(int activeTabIndex) {
		this.activeTabIndex = activeTabIndex;
	}

	public ResourceDTO getNewResource() {
		return newResource;
	}

	public void setNewResource(ResourceDTO newResource) {
		this.newResource = newResource;
	}
}
