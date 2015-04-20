package pwr.itApp.customerStaff.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.domain.enums.MeasureUnit;
import pwr.itApp.customerStaff.domain.enums.ResourceType;
import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.ResourceDTO;
import pwr.itApp.customerStaff.service.ResourcesService;
import pwr.itApp.customerStaff.webapp.ApplicationURL;
import pwr.itApp.customerStaff.webapp.login.Actor;

@Component("resourcesBean")
@Scope("view")
public class ResourcesBean implements ElementsList<ResourceDTO>, Serializable{

	private static final long serialVersionUID = 7486937318441787833L;

	@Autowired
	private Actor actor;
	
	@Autowired
	private ResourcesService resourcesService;
	
	private static final ResourceType RESOURCE_TABS[] = ResourceType.values();

	private static final String RESOURCE_TO_EDIT = "edit";
	private List<ResourceDTO> liquidResources;
	private List<ResourceDTO> gramResources;
	private List<ResourceDTO> pieceResources;
	private ResourceDTO selectedResource;
	private ResourceDTO newResource;
	private boolean newResourceAddMode;
	private boolean minimalAmountDialogShown;
	private int activeTabIndex;
	private boolean editResourceAddMode;
	
	@PostConstruct
	public void init() {
		initFromFlashScope();
	}
	
	private void initFromFlashScope() {
		newResource = (ResourceDTO) FacesContext.getCurrentInstance().getExternalContext()
                .getFlash().get(RESOURCE_TO_EDIT);
		if (newResource != null) {
			activeTabIndex = findResourceTypeInArray(newResource.getResourceType());
			newResourceAddMode = true;
			editResourceAddMode = true;
		} else {
			newResource = new ResourceDTO();
			newResource.setResourceType(RESOURCE_TABS[activeTabIndex]);
		}
	}
	
	private int findResourceTypeInArray(ResourceType type) {
		for (int i=0; i<RESOURCE_TABS.length; i++) {
			if (RESOURCE_TABS[i] == type) {
				return i;
			}
		}
		
		return -1;
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
		newResource = new ResourceDTO();
		newResource.setResourceType(RESOURCE_TABS[activeTabIndex]);
	}
	
	public void onNewMinimalAmountConfirm() {
		minimalAmountDialogShown = false;
	}
	
	public void onTabChange() {
		newResource.setResourceType(RESOURCE_TABS[activeTabIndex]);
	}
	
	public void onEditResource() {
//		newResource = selectedResource;
//		selectedResource = null;
		FacesContext.getCurrentInstance().getExternalContext()
                .getFlash().put(RESOURCE_TO_EDIT, selectedResource);
		ApplicationURL.redirect(ApplicationURL.RESOURCES + ApplicationURL.RELOAD);
//		newResourceAddMode = false;
	}
	
	public void onResourceUpdate() {
		resourcesService.updateResource(newResource);
	}
	
	public void changeMinimalAmountDialogVisibility() {
		minimalAmountDialogShown = !minimalAmountDialogShown;
	}
	
	public void onNewResource() {
		newResource.setRestaurantId(actor.getChosenRestaurantId());
		resourcesService.createResource(newResource);
		ApplicationURL.redirect(ApplicationURL.RESOURCES + ApplicationURL.RELOAD);
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
		newResourceAddMode = false;
		selectedResource = resource;
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
	
	public boolean isEditResourceAddMode() {
		return editResourceAddMode;
	}

	public boolean isMinimalAmountDialogShown() {
		return minimalAmountDialogShown;
	}
	
	public boolean isMinimalAmountEditable() {
		return true;
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
	
	public List<MeasureUnit> getMeasureUnits() {
		return MeasureUnit.getByResourceType(newResource.getResourceType());
	}
}
