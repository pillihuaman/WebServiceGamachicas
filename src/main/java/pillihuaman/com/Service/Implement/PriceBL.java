package pillihuaman.com.Service.Implement;
import pillihuaman.com.BusinessEntity.Base.Price;
import pillihuaman.com.dao.Impl.PriceDA;
import pillihuaman.com.model.response.PriceResponse;

public class PriceBL {

	public static PriceResponse PriceIns(Price price) {
		return PriceDA.PriceIns(price);
	}
	public static Price PriceSel(Price price) {
		return PriceDA.PriceSel(price);
	}


}
	
