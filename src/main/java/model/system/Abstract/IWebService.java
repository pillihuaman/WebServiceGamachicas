package model.system.Abstract;

import java.sql.SQLException;
import java.util.List;
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

public interface IWebService {
	ModelEntities listaProductos();
	List<ViewStockBE> listGeneralProductForm(int IdImagen) throws SQLException, Exception;
	boolean InsertStock(Stock stock);


	List<HomeViewModel> ListDetImagenByIdImagen(Imagen pro);


	List<Menu> MenuList( Groupparameter Groupparameter);
	List<ParentMenu> parentmenuList( ParentMenu  ParentMenu);
	List<Parameter> Parametersel(Parameter Parameter);


	DetailImagenResponse DetailImagenIns(Detailimagen detailImagen);
	
	
}
