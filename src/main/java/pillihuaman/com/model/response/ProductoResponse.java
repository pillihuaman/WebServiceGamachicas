package pillihuaman.com.model.response;

import java.util.List;

import pillihuaman.com.BusinessEntity.Base.Product;
import pillihuaman.com.BusinessEntity.Base.Response;

public class ProductoResponse extends Response {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Product getProduct() {
		return Product;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setProduct(Product product) {
		Product = product;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	private Product Product;
	private List<Product> listProduct;
}
