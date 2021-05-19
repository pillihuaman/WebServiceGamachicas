package pillihuaman.com.model.response;

import java.util.List;

import pillihuaman.com.BusinessEntity.Base.Price;
import pillihuaman.com.BusinessEntity.Base.Response;

public class PriceResponse extends Response {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Price getPrice() {
		return price;
	}
	public List<Price> getListPrice() {
		return listPrice;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public void setListPrice(List<Price> listPrice) {
		this.listPrice = listPrice;
	}
	private Price price;
	private List<Price> listPrice;
	

}
