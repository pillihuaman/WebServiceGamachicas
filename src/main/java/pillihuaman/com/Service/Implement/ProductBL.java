package pillihuaman.com.Service.Implement;

import java.util.List;

import pillihuaman.com.BusinessEntity.Base.Detailimagen;
import pillihuaman.com.BusinessEntity.Base.Detailproduct;
import pillihuaman.com.BusinessEntity.Base.HomeViewModel;
import pillihuaman.com.BusinessEntity.Base.Imagen;
import pillihuaman.com.BusinessEntity.Base.Product;
import pillihuaman.com.dao.Impl.ProductDA;
import pillihuaman.com.dao.Impl.WebServiceDA;
import pillihuaman.com.model.response.HomeViewModelResponse;
import pillihuaman.com.model.response.ProductoResponse;

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
	public static boolean RegisterDetailImagen(Detailimagen pro) {
		return ProductDA.RegisterDetailImagen(pro);
		
	}

}
