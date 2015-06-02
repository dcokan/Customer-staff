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
import pwr.itApp.customerStaff.persistance.ProductDAO;
import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.ProductDTO;
import pwr.itApp.customerStaff.presentation.dto.ResourceDTO;
import pwr.itApp.customerStaff.service.ProductService;
import pwr.itApp.customerStaff.service.ResourcesService;
import pwr.itApp.customerStaff.service.RestaurantService;
import pwr.itApp.customerStaff.webapp.ApplicationURL;
import pwr.itApp.customerStaff.webapp.ResourceBundle;
import pwr.itApp.customerStaff.webapp.login.Actor;
import pwr.itApp.customerStaff.webapp.utils.LabelUtils;

@Component("productBean")
@Scope(value = "view")
public class ProductBean implements Serializable, ElementsList<ProductDTO>{

	private static final long serialVersionUID = 7519617970252000923L;
	private static final ProductType PRODUCT_TYPES[] = ProductType.values();
	private static final String PRODUCT_EDIT = "edit_product";

	@Autowired
	private ProductService productService;
	
	@Autowired 
	private ProductDAO productRepo;
	
	@Autowired
	private ResourcesService resourceService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private Actor actor;
	
	@Autowired
	private ResourceBundle rb;
	
	private int activeTabIndex;
	private ProductDTO newProduct;
	private ProductDTO selectedProduct;
	private List<ResourceDTO> resourcesList;
	private Double resourceAmount;
	private boolean newProductMode;
	private ResourceDTO resourceToBeAdded;
	private List<ProductsViewData> tabs;
	private Map<Integer, String> resourcesInProductLabels;
	private ProductType selectedProductType;
	private boolean editProductMode;
	
	@PostConstruct
	public void init() {
		resourcesInProductLabels = new HashMap<Integer, String>();
		initTabs();
		initFromFlash();
	}

	//TODO : Consider removing selected Product value and using in all occurrences newProduct instead
	private void initFromFlash() {
		newProduct = (ProductDTO) ApplicationURL.getFromFlash(PRODUCT_EDIT);
		editProductMode = newProduct != null;
		if (editProductMode) {
			resourcesInProductLabels = resourceService.getResourceLabels(newProduct.getResourcesInProduct());
		}
	}

	private void initTabs() {		
		tabs = new ArrayList<ProductsViewData>();
		for (ProductType type: PRODUCT_TYPES) {
			ProductsViewData productData = new ProductsViewData();
			productData.setProductList(restaurantService.getProductsByType(actor.getChosenRestaurant(), type));
			productData.setEmptyDescription(getFormattedEmptyDesc(type));
			productData.setImageURL(type.getImageURL());
			productData.setTitle(rb.getString(type.getNameKey()));
			tabs.add(productData);
		}
	}

	public void onResourceAdded() {
		resourceAmount = newProduct.addResourceToReceipt(resourceToBeAdded.getId(), resourceAmount);
		if (resourcesInProductLabels.containsKey(resourceToBeAdded.getId())) {
			resourcesInProductLabels.remove(resourceToBeAdded.getId());
		} 
		resourcesInProductLabels.put(resourceToBeAdded.getId(), LabelUtils.prepareResourceLabel(
				resourceToBeAdded.getName(), resourceAmount));
	}

	public List<ProductsViewData> getproductsViewData() {
		return tabs;
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
		resourcesInProductLabels = new HashMap<Integer, String>();
		newProduct = new ProductDTO();
	}

	public void onProductUpdate() {
		productService.updateProduct(newProduct);
		ApplicationURL.redirect(ApplicationURL.PRODUCTS);
	}
	
	public void onNewProduct() {
		newProduct.setProductType(selectedProductType);
		assignProductToRestaurant();
		restaurantService.updateRestaurant(actor.getChosenRestaurant());
		ApplicationURL.redirect(ApplicationURL.PRODUCTS);
	}
	
	private void assignProductToRestaurant() {
		actor.getChosenRestaurant().getProducts().add(newProduct);
	}

	public void onTabChange() {
		newProduct = null;
		selectedProductType = PRODUCT_TYPES[activeTabIndex];
	}
	
	public void onEditProduct() {
		ApplicationURL.puToFlash(PRODUCT_EDIT, selectedProduct);
		ApplicationURL.redirect(ApplicationURL.PRODUCTS);
	}
	
	@Override
	public void onDeailShowButton(ProductDTO item) {
		selectedProduct = item;
	}
	
	public double getMaxAmountInProduct() {
		return resourceToBeAdded == null ? 0 : resourceToBeAdded.getMinimalAmount()*10000;
	}

	public void onResourceSelected() {
		resourceAmount = resourceToBeAdded.getMinimalAmount();
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
	
	public ResourceDTO getResourceToBeAdded() {
		return resourceToBeAdded;
	}

	public void setResourceToBeAdded(ResourceDTO resourceToBeAdded) {
		this.resourceToBeAdded = resourceToBeAdded;
	}
	
	public Collection<String> getResourcesInProduct() {
		return resourcesInProductLabels.values();
	}

//	private ResourceDTO findInResourcesList(Integer id) {
//		for (ResourceDTO resource: resourcesList) {
//			if (resource.getId().equals(id)) {
//				return resource;
//			}
//		}
//		return null;
//	}

	public ProductDTO getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(ProductDTO selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public boolean isEditProductMode() {
		return editProductMode;
	}

	public void setEditProductMode(boolean editProductMode) {
		this.editProductMode = editProductMode;
	}
}
