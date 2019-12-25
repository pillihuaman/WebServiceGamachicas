package model.system.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import common.system.ViewModel.ListImagenByIdProductModelAndView;
import common.system.ViewModel.ModelEntities;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Producto;
import domain.System.BusinessEntity.Base.Stock;
import domain.System.BusinessEntity.BusinessLogic.WebServiceBL;
import model.system.Abstract.IWebService;
import repository.System.DataAccess.MySql.WebServiceDA;
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
	public List<Stock> InsertStock(Stock stock) {
		// TODO Auto-generated method stub
		return  WebServiceBL.InsertStock(stock);
	}

	@Override
	public List<Producto> ListProduct() {
		// TODO Auto-generated method stub
		return  WebServiceBL.ListProduct();
	}
	@Override
	public ListImagenByIdProductModelAndView ListImagenByIdProduct(Producto pro) {
		// TODO Auto-generated method stub
		return WebServiceBL.ListImagenByIdProduct(pro);
	}



}
