package domain.System.BusinessEntity.BusinessLogic;

import java.util.List;

import common.system.model.response.HomeViewModelResponse;
import common.system.model.response.ProductoResponse;
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Product;
import repository.System.DataAccess.MySql.ProductDA;
import repository.System.DataAccess.MySql.WebServiceDA;

public class ProductBL {
	public static ProductoResponse ListProduct() {
		return ProductDA.ListProduct();
	}

	public static List<HomeViewModel> ListDetImagenByIdProduct(Product pro) {
		return ProductDA.ListDetImagenByIdProduct(pro);
	}

	public static List<HomeViewModel> ListDetImagenByIdImagen(Imagen img) {
		return ProductDA.ListDetImagenByIdImagen(img);
	}

	public static ProductoResponse ProductoSel(Product pro) {
		return ProductDA.ProductoSel(pro);
	}

	public static HomeViewModel HomeViewModelSelByIdDroducto(Product pro) {
		return ProductDA.HomeViewModelSelByIdDroducto(pro);
	}

	public static boolean DetailProductIns(Detailproduct pro) {
		return ProductDA.DetailProductIns(pro);
	}

	public static List<Detailproduct> ListDetailProductByIdProduct(Detailproduct pro) {
		return ProductDA.ListDetailProductByIdProduct(pro);
	}

	public static ProductoResponse SaveProduct(Product Product) {
		return ProductDA.SaveProduct(Product);
	}
	public static HomeViewModelResponse HomeProductIns(HomeViewModel homeViewModel) {
		return ProductDA.HomeProductIns(homeViewModel);
		// WebServiceDA.ImagenIns(Imagen);
	}

}
