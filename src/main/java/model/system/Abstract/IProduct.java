package model.system.Abstract;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import common.system.model.response.HomeViewModelResponse;
import common.system.model.response.ProductoResponse;
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Product;

public interface IProduct {
	HomeViewModel HomeViewModelSelByIdDroducto(Product pro);
	List<HomeViewModel> ListDetImagenByIdProduct(Product pro);
	ProductoResponse ListProduct();
	ProductoResponse ProductoSel(Product pro);
	boolean DetailProductIns(@RequestBody Detailproduct pro);
	List<Detailproduct> ListDetailProductByIdProduct(Detailproduct pro);
	ProductoResponse SaveProduct(@RequestBody Product pro);
	HomeViewModelResponse HomeProductIns(HomeViewModel homeViewModel);
}
