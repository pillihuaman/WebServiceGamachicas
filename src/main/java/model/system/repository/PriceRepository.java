package model.system.repository;

import common.system.model.response.PriceResponse;
import domain.System.BusinessEntity.Base.Price;
import model.system.Abstract.IPrice;
import repository.System.DataAccess.MySql.PriceDA;
import repository.System.DataAccess.MySql.WebServiceDA;

public class PriceRepository implements IPrice {

	@Override
	public PriceResponse PriceIns(Price price) {
		PriceDA obj = new PriceDA();
		return obj.PriceIns(price);
	}

	@Override
	public Price PriceSel(Price price) {
		PriceDA obj = new PriceDA();
		return obj.PriceSel(price);
	}

}
