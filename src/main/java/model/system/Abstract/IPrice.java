package model.system.Abstract;
import common.system.model.response.PriceResponse;
import domain.System.BusinessEntity.Base.Price;
public interface  IPrice {
	PriceResponse PriceIns(Price price) ;
	Price PriceSel(Price price);

}
