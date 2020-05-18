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

	public static List<Product> ListProduct() {
		return WebServiceDA.ListProduct();
	}

	public static HomeViewModelResponse ListImagenByIdProduct(Product pro) {
		return WebServiceDA.ListImagenByIdProduct(pro);
	}

	public static List<HomeViewModel> ListDetImagenByIdProduct(Product pro) {
		return WebServiceDA.ListDetImagenByIdProduct(pro);
	}

	public static ImagenResponse ImagenSel(Imagen img) {
		return WebServiceDA.ImagenSel(img);
	}

	public static List<HomeViewModel> ListDetImagenByIdImagen(Imagen img) {
		return WebServiceDA.ListDetImagenByIdImagen(img);
	}

	public static ProductoResponse ProductoSel(Product pro) {
		return WebServiceDA.ProductoSel(pro);
	}

	public static HomeViewModel HomeViewModelSelByIdDroducto(Product pro) {
		return WebServiceDA.HomeViewModelSelByIdDroducto(pro);
	}

	public static boolean DetailProductIns(Detailproduct pro) {
		return WebServiceDA.DetailProductIns(pro);
	}
	public static  List<Menu> MenuList(@RequestBody Groupparameter Groupparameter) {
		return WebServiceDA.MenuList(Groupparameter);
	}


	public static List<Detailproduct> ListDetailProductByIdProduct(Detailproduct pro) {
		return WebServiceDA.ListDetailProductByIdProduct(pro);
	}
	public static List<ParentMenu> parentmenuList(ParentMenu ParentMenu) {
		return WebServiceDA.parentmenuList(ParentMenu);
	}
	public static List<Parameter> Parametersel(Parameter Parameter) {
		return WebServiceDA.Parametersel(Parameter);
	}
	public static ProductoResponse SaveProduct(Product Product) {
		return WebServiceDA.SaveProduct(Product);
	}
	public static ImagenResponse ImagenIns(Imagen Imagen) {
		return WebServiceDA.ImagenIns(Imagen);
	}
	public static ImagenResponse ImagenInss(Imagen Imagen) {
		return WebServiceDA.ImagenInss(Imagen);
				//WebServiceDA.ImagenIns(Imagen);
	}
	public static PriceResponse PriceIns(Price price) {
		return WebServiceDA.PriceIns(price);
				//WebServiceDA.ImagenIns(Imagen);
	}
	public static HomeViewModelResponse HomeProductIns(HomeViewModel homeViewModel) {
		return WebServiceDA.HomeProductIns(homeViewModel);
				//WebServiceDA.ImagenIns(Imagen);
	}
	public static DetailImagenResponse DetailImagenIns(Detailimagen detailImagen) {
		return WebServiceDA.DetailImagenIns(detailImagen);
				//WebServiceDA.ImagenIns(Imagen);
	}
}
