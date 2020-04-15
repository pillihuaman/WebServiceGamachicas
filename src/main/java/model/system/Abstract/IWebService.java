package model.system.Abstract;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import common.system.ViewModel.ListImagenByIdProductModelAndView;
import common.system.ViewModel.ModelEntities;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Producto;
import domain.System.BusinessEntity.Base.Stock;

public interface IWebService {
	ModelEntities listaProductos();

	List<ViewStockBE> listGeneralProductForm(int IdImagen) throws SQLException, Exception;

	List<Stock> InsertStock(Stock stock);

	List<Producto> ListProduct();

	List<HomeViewModel> ListImagenByIdProduct(Producto pro);

	List<HomeViewModel> ListDetImagenByIdProduct(Producto pro);

	Imagen ImagenSel(Imagen img);

	List<HomeViewModel> ListDetImagenByIdImagen(Imagen pro);

	Producto ProductoSel(Producto pro);

	HomeViewModel HomeViewModelSelByIdDroducto(Producto pro);

	boolean DetailProductIns(@RequestBody Detailproduct pro);
	 List<Detailproduct> ListDetailProductByIdProduct(Detailproduct pro);
}
