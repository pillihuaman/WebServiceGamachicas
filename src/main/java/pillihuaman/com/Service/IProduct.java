package pillihuaman.com.Service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import pillihuaman.com.BusinessEntity.Base.Detailimagen;
import pillihuaman.com.BusinessEntity.Base.Detailproduct;
import pillihuaman.com.BusinessEntity.Base.HomeViewModel;
import pillihuaman.com.BusinessEntity.Base.Product;
import pillihuaman.com.model.response.HomeViewModelResponse;
import pillihuaman.com.model.response.ProductoResponse;

public interface IProduct {
	HomeViewModel HomeViewModelSelByIdDroducto(Product pro);
	List<HomeViewModel> ListDetImagenByIdProduct(Product pro);
	ProductoResponse ListProduct();
	ProductoResponse ProductoSel(Product pro);
	boolean DetailProductIns(@RequestBody Detailproduct pro);
	List<Detailproduct> ListDetailProductByIdProduct(Detailproduct pro);
	ProductoResponse SaveProduct(@RequestBody Product pro);
	HomeViewModelResponse HomeProductIns(HomeViewModel homeViewModel);
	boolean RegisterDetailImagen(Detailimagen pro);
}
