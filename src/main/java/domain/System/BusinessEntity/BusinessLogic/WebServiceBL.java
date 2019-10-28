package domain.System.BusinessEntity.BusinessLogic;

import java.util.List;
import domain.System.BusinessEntity.Base.Producto;
import repository.System.DataAccess.MySql.WebServiceDA;

public class WebServiceBL {
	  public static   List<Producto> listaProductos() 
	    { 
         return WebServiceDA.listaProductos();
	    }
	  
}
