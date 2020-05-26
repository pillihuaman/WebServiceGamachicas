package domain.System.BusinessEntity.BusinessLogic;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import common.system.model.response.*;
import common.system.ViewModel.ModelEntities;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.*;
import repository.System.DataAccess.MySql.WebServiceDA;

public class WebServiceBL {
	public static ModelEntities listaProductos() {
		return WebServiceDA.listaProductos();
	}

	public List<ViewStockBE> listGeneralProductForm(int idImagen) throws Exception, SQLException {
		WebServiceDA obj = new WebServiceDA();
		return obj.listGeneralProductForm(idImagen);
	}

	public static boolean InsertStock(Stock stockd) {
		return WebServiceDA.Stockins(stockd);
	}

	public static ImagenResponse ImagenSel(Imagen img) {
		return WebServiceDA.ImagenSel(img);
	}

	public static List<Menu> MenuList(@RequestBody Groupparameter Groupparameter) {
		return WebServiceDA.MenuList(Groupparameter);
	}

	public static List<ParentMenu> parentmenuList(ParentMenu ParentMenu) {
		return WebServiceDA.parentmenuList(ParentMenu);
	}

	public static List<Parameter> Parametersel(Parameter Parameter) {
		return WebServiceDA.Parametersel(Parameter);
	}



	public static DetailImagenResponse DetailImagenIns(Detailimagen detailImagen) {
		return WebServiceDA.DetailImagenIns(detailImagen);
		// WebServiceDA.ImagenIns(Imagen);
	}
}
