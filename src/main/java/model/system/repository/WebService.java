package model.system.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import common.system.model.response.*;
import common.system.ViewModel.ModelEntities;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Detailimagen;
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.Groupparameter;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Menu;
import domain.System.BusinessEntity.Base.Parameter;
import domain.System.BusinessEntity.Base.ParentMenu;
import domain.System.BusinessEntity.Base.Price;
import domain.System.BusinessEntity.Base.Product;
import domain.System.BusinessEntity.Base.Stock;
import domain.System.BusinessEntity.BusinessLogic.WebServiceBL;
import model.system.Abstract.IWebService;
@Service
public class WebService implements IWebService {

	@Override
	public ModelEntities listaProductos() {
		// TODO Auto-generated method stub
		return  WebServiceBL.listaProductos();
	}

	@Override
	public List<ViewStockBE> listGeneralProductForm(int idImagen) throws SQLException, Exception {
		// TODO Auto-generated method stub
		WebServiceBL obj = new WebServiceBL();
	        return  obj.listGeneralProductForm(idImagen);
	}

	@Override
	public boolean InsertStock(Stock stock) {
		// TODO Auto-generated method stub
		return  WebServiceBL.InsertStock(stock);
	}

	
	

	@Override
	public List<Menu> MenuList(@RequestBody Groupparameter Groupparameter) {
		// TODO Auto-generated method stub
		return WebServiceBL.MenuList(Groupparameter);
	}

	@Override
	public List<ParentMenu> parentmenuList(ParentMenu ParentMenu) {
		// TODO Auto-generated method stub
		return WebServiceBL.parentmenuList(ParentMenu);
	}
	@Override
	public List<Parameter> Parametersel(Parameter Parameter) {
		// TODO Auto-generated method stub
		return WebServiceBL.Parametersel(Parameter);
	}



//	@Override
//	public PriceResponse PriceIns(Price price) {
//		// TODO Auto-generated method stub
//		return WebServiceBL.PriceIns(price);
//	}



	@Override
	public DetailImagenResponse DetailImagenIns(Detailimagen detailImagen) {
		// TODO Auto-generated method stub
		return WebServiceBL.DetailImagenIns(detailImagen);
	}

	@Override
	public List<HomeViewModel> ListDetImagenByIdImagen(Imagen pro) {
		// TODO Auto-generated method stub
		return null;
	}








}
