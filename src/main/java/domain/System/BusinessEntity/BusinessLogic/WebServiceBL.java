package domain.System.BusinessEntity.BusinessLogic;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import common.system.ViewModel.ListImagenByIdProductModelAndView;
import common.system.ViewModel.ModelEntities;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Producto;
import domain.System.BusinessEntity.Base.Stock;
import repository.System.DataAccess.MySql.WebServiceDA;

public class WebServiceBL {
	  public static  ModelEntities listaProductos() 
	    { 
         return WebServiceDA.listaProductos();
	    }
	  
	  public   List<ViewStockBE>  listGeneralProductForm (int idImagen) throws Exception, SQLException 
	    { 
		  WebServiceDA obj = new WebServiceDA();
        return  obj.listGeneralProductForm(idImagen);
	    }
	  public static  List<Stock> InsertStock(Stock stockd) {
		return WebServiceDA.InsertStock(stockd);
	} 
	  public static List<Producto> ListProduct() {
		return WebServiceDA.ListProduct();
	} 
	  public static    ListImagenByIdProductModelAndView ListImagenByIdProduct(Producto pro)
	    { 
     return WebServiceDA.ListImagenByIdProduct(pro);
	    }
	  
	  
}
