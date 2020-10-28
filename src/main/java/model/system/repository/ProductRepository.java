package model.system.repository;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import common.system.model.response.HomeViewModelResponse;
import common.system.model.response.ProductoResponse;
import domain.System.BusinessEntity.Base.Detailimagen;
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Product;
import domain.System.BusinessEntity.BusinessLogic.ProductBL;
import domain.System.BusinessEntity.BusinessLogic.WebServiceBL;
import model.system.Abstract.IProduct;

public class ProductRepository implements IProduct {
	@Override
	public ProductoResponse ListProduct() {
		// TODO Auto-generated method stub
		return  ProductBL.ListProduct();
	}

	@Override
	public List<HomeViewModel> ListDetImagenByIdProduct(Product pro) {
		// TODO Auto-generated method stub
		return ProductBL.ListDetImagenByIdProduct(pro);
	}
	@Override
	public ProductoResponse  ProductoSel(Product pro) {
		// TODO Auto-generated method stub
		return ProductBL.ProductoSel(pro);
	}
	@Override
	public HomeViewModel HomeViewModelSelByIdDroducto(Product pro) {
		// TODO Auto-generated method stub
		return ProductBL.HomeViewModelSelByIdDroducto(pro);
	}

	@Override
	public boolean DetailProductIns(@RequestBody Detailproduct pro) {
		// TODO Auto-generated method stub
		return ProductBL.DetailProductIns(pro);
	}
	@Override
	public List<Detailproduct> ListDetailProductByIdProduct( Detailproduct pro) {
		// TODO Auto-generated method stub
		return ProductBL.ListDetailProductByIdProduct(pro);
	}
	@Override
	public ProductoResponse SaveProduct(Product pro) {
		// TODO Auto-generated method stub
		return ProductBL.SaveProduct(pro);
	}
	@Override
	public HomeViewModelResponse HomeProductIns(HomeViewModel homeViewModel) {
		// TODO Auto-generated method stub
		return ProductBL.HomeProductIns(homeViewModel);
	}

	@Override
	public boolean RegisterDetailImagen(Detailimagen pro) {
		// TODO Auto-generated method stub
		return ProductBL.RegisterDetailImagen(pro);
	}

}
