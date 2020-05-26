package domain.System.BusinessEntity.BusinessLogic;
import common.system.model.response.PriceResponse;
import domain.System.BusinessEntity.Base.Price;
import repository.System.DataAccess.MySql.PriceDA;

public class PriceBL {

	public static PriceResponse PriceIns(Price price) {
		return PriceDA.PriceIns(price);
	}
	public static Price PriceSel(Price price) {
		return PriceDA.PriceSel(price);
	}


}
	
