package model.system.Abstract;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import common.system.ViewModel.ListImagenByIdProductModelAndView;
import common.system.ViewModel.ModelEntities;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Producto;
import domain.System.BusinessEntity.Base.Stock;
public interface  IWebService 
{
	ModelEntities  listaProductos();
	List<ViewStockBE> listGeneralProductForm(int IdImagen) throws SQLException, Exception;
	List<Stock> InsertStock(Stock stock);
	List<Producto> ListProduct() ;
ListImagenByIdProductModelAndView ListImagenByIdProduct(Producto pro);
}
