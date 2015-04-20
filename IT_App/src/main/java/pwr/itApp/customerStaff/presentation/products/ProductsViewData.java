package pwr.itApp.customerStaff.presentation.products;

import java.util.List;

import pwr.itApp.customerStaff.presentation.dto.ProductDTO;

public class ProductsViewData {


	private List<ProductDTO> productList;
	private String emptyDesc;
	private String imageURL;
	private String title;

	public void setProductList(List<ProductDTO> productsByType) {
		this.productList = productsByType;
	}

	public void setEmptyDescription(String emptyDesc) {
		this.emptyDesc = emptyDesc;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public List<ProductDTO> getProductList() {
		return productList;
	}

	public String getEmptyDesc() {
		return emptyDesc;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setEmptyDesc(String emptyDesc) {
		this.emptyDesc = emptyDesc;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}
