package pillihuaman.com.Service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;

import pillihuaman.com.BusinessEntity.ViewStockBE;
import pillihuaman.com.BusinessEntity.Base.Detailimagen;
import pillihuaman.com.BusinessEntity.Base.Detailproduct;
import pillihuaman.com.BusinessEntity.Base.Groupparameter;
import pillihuaman.com.BusinessEntity.Base.HomeViewModel;
import pillihuaman.com.BusinessEntity.Base.Imagen;
import pillihuaman.com.BusinessEntity.Base.Menu;
import pillihuaman.com.BusinessEntity.Base.Parameter;
import pillihuaman.com.BusinessEntity.Base.ParentMenu;
import pillihuaman.com.BusinessEntity.Base.Price;
import pillihuaman.com.BusinessEntity.Base.Product;
import pillihuaman.com.BusinessEntity.Base.Stock;
import pillihuaman.com.ViewModel.ModelEntities;
import pillihuaman.com.model.response.*;

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
