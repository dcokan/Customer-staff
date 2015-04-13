package pwr.itApp.customerStaff.presentation;

import java.util.ArrayList;
import java.util.List;

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
	public String onNewItemButton() {
		// TODO Auto-generated method stub
		return null;
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
		throw new UnsupportedOperationException("Bean doesn't support this operation");
	}
}
