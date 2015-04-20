package pwr.itApp.customerStaff.presentation.products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.domain.enums.ProductType;
import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.ProductDTO;
import pwr.itApp.customerStaff.service.ProductService;
import pwr.itApp.customerStaff.webapp.ResourceBundle;

@Component("productBean")
@Scope(value = "view")
public class ProductBean implements Serializable, ElementsList<ProductDTO>{

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ResourceBundle rb;
	
	private int activeTabIndex;
	
	public List<ProductsViewData> getproductsViewData() {
		List<ProductsViewData> data = new ArrayList<ProductsViewData>();
		for (ProductType type: ProductType.values()) {
			ProductsViewData productData = new ProductsViewData();
			productData.setProductList(productService.getProductsByType(type));
			productData.setEmptyDescription(getFormattedEmptyDesc(type));
			productData.setImageURL(type.getImageURL());
			productData.setTitle(rb.getString(type.getId()));
			data.add(productData);
		}
		
		return data;
	}

	private String getFormattedEmptyDesc(ProductType type) {
		return "Create new product of type" + type;
	}

	@Override
	public List<ProductDTO> getValueList() {
		return null;
	}

	@Override
	public void onNewItemButton() {
		//TODO: init new Product with appropriate type
	}

	@Override
	public void onDeailShowButton(ProductDTO item) {
		//TODO: 
	}

	public int getActiveTabIndex() {
		return activeTabIndex;
	}

	public void setActiveTabIndex(int activeTabIndex) {
		this.activeTabIndex = activeTabIndex;
	}
}
