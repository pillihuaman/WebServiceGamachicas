package pillihuaman.com.Service;
import pillihuaman.com.BusinessEntity.Base.Price;
import pillihuaman.com.model.response.PriceResponse;
public interface  IPrice {
	PriceResponse PriceIns(Price price) ;
	Price PriceSel(Price price);

}
