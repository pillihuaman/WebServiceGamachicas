package domain.System.BusinessEntity.BusinessLogic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import common.system.ViewModel.ListImagenByIdProductModelAndView;
import common.system.ViewModel.ModelEntities;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Producto;
import domain.System.BusinessEntity.Base.Stock;
import repository.System.DataAccess.MySql.WebServiceDA;

public class WebServiceBL {
	public static ModelEntities listaProductos() {
		return WebServiceDA.listaProductos();
	}

	public List<ViewStockBE> listGeneralProductForm(int idImagen) throws Exception, SQLException {
		WebServiceDA obj = new WebServiceDA();
		return obj.listGeneralProductForm(idImagen);
	}

	public static List<Stock> InsertStock(Stock stockd) {
		return WebServiceDA.InsertStock(stockd);
	}

	public static List<Producto> ListProduct() {
		return WebServiceDA.ListProduct();
	}

	public static List<HomeViewModel> ListImagenByIdProduct(Producto pro) {
		return WebServiceDA.ListImagenByIdProduct(pro);
	}

	public static List<HomeViewModel> ListDetImagenByIdProduct(Producto pro) {
		return WebServiceDA.ListDetImagenByIdProduct(pro);
	}

	public static Imagen ImagenSel(Imagen img) {
		return WebServiceDA.ImagenSel(img);
	}

	public static List<HomeViewModel> ListDetImagenByIdImagen(Imagen img) {
		return WebServiceDA.ListDetImagenByIdImagen(img);
	}

	public static Producto ProductoSel(Producto pro) {
		return WebServiceDA.ProductoSel(pro);
	}

	public static HomeViewModel HomeViewModelSelByIdDroducto(Producto pro) {
		return WebServiceDA.HomeViewModelSelByIdDroducto(pro);
	}

	public static boolean DetailProductIns(Detailproduct pro) {
		return WebServiceDA.DetailProductIns(pro);
	}

	public static List<Detailproduct> ListDetailProductByIdProduct(Detailproduct pro) {
		return WebServiceDA.ListDetailProductByIdProduct(pro);
	}
}
