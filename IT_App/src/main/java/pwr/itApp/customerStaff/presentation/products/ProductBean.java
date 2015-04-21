package pwr.itApp.customerStaff.presentation.products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.domain.enums.ProductType;
import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.ProductDTO;
import pwr.itApp.customerStaff.presentation.dto.ResourceDTO;
import pwr.itApp.customerStaff.service.ProductService;
import pwr.itApp.customerStaff.service.ResourcesService;
import pwr.itApp.customerStaff.webapp.ResourceBundle;
import pwr.itApp.customerStaff.webapp.login.Actor;

@Component("productBean")
@Scope(value = "view")
public class ProductBean implements Serializable, ElementsList<ProductDTO>{

	private static final long serialVersionUID = 7519617970252000923L;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ResourcesService resourceService;
	
	@Autowired
	private Actor actor;
	
	@Autowired
	private ResourceBundle rb;
	
	private int activeTabIndex;
	private ProductDTO newProduct;
	private ProductDTO selectedProduct;
	private List<ResourceDTO> resourcesList;
	private Double resourceAmount;
	private Map<Double, ResourceDTO> resourcesInProduct;
	private boolean newProductMode;
	private ResourceDTO resourceToBeAdded;
	
	@PostConstruct
	public void init() {
		resourcesInProduct = new HashMap<Double, ResourceDTO>();
	}

	public void onResourceAdded() {
		
	}
	
	public Collection<ResourceDTO> getResourcesInProduct() {
		return resourcesInProduct.values();
	}
	
	public List<ProductsViewData> getproductsViewData() {
		List<ProductsViewData> data = new ArrayList<ProductsViewData>();
		for (ProductType type: ProductType.values()) {
			ProductsViewData productData = new ProductsViewData();
			productData.setProductList(productService.getProductsByType(type));
			productData.setEmptyDescription(getFormattedEmptyDesc(type));
			productData.setImageURL(type.getImageURL());
			productData.setTitle(rb.getString(type.getNameKey()));
			data.add(productData);
		}
		
		return data;
	}

	private String getFormattedEmptyDesc(ProductType type) {
		return "Create new product of type" + type;
	}
	
	public List<ResourceDTO> getResourcesFromRestaurant() {
		if (resourcesList == null) {
			resourcesList = resourceService.getAllRestaurantResources(actor.getChosenRestaurantId());
		}
		
		return resourcesList;
	}

	@Override
	public List<ProductDTO> getValueList() {
		return null;
	}

	@Override
	public void onNewItemButton() {
		newProductMode = true;
		selectedProduct = null;
		newProduct = new ProductDTO();
	}

	@Override
	public void onDeailShowButton(ProductDTO item) {
		selectedProduct = item;
	}

	public boolean isProductSelected() {
		return selectedProduct != null;
	}
	
	public boolean isNewProductMode() {
		return newProductMode;
	}
	
	public int getActiveTabIndex() {
		return activeTabIndex;
	}

	public void setActiveTabIndex(int activeTabIndex) {
		this.activeTabIndex = activeTabIndex;
	}

	public ProductDTO getNewProduct() {
		return newProduct;
	}

	public List<ResourceDTO> getResourcesList() {
		return resourcesList;
	}

	public Double getResourceAmount() {
		return resourceAmount;
	}

	public void setNewProduct(ProductDTO newProduct) {
		this.newProduct = newProduct;
	}

	public void setResourcesList(List<ResourceDTO> resourcesList) {
		this.resourcesList = resourcesList;
	}

	public void setResourceAmount(Double resourceAmount) {
		this.resourceAmount = resourceAmount;
	}

	public void setResourcesInProduct(Map<Double, ResourceDTO> resourcesInProduct) {
		this.resourcesInProduct = resourcesInProduct;
	}

	public ResourceDTO getResourceToBeAdded() {
		return resourceToBeAdded;
	}

	public void setResourceToBeAdded(ResourceDTO resourceToBeAdded) {
		this.resourceToBeAdded = resourceToBeAdded;
	}
}
