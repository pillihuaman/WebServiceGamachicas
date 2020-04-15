package common.system.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import common.system.ViewModel.ListImagenByIdProductModelAndView;
import common.system.ViewModel.ModelEntities;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Producto;
import domain.System.BusinessEntity.Base.Stock;
import model.system.Abstract.IWebService;
import model.system.repository.WebService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("WebService")
public class WebServiceController {
	// parte del repositorio
	// @Autowired
	// private IWebService pro;
	@GetMapping(value = "/ListaProducto", produces = "application/json; charset=UTF-8")
	// @GetMapping("/ListaProducto",produces ="")
	public ModelEntities ListaProducto() {
		WebService WebService = new WebService();
		ModelEntities list = WebService.listaProductos();
		return list;
	}

	@GetMapping(value = "/listGeneralProductForm", produces = "application/json; charset=UTF-8")
//@GetMapping("/ListaProducto",produces ="")
	public List<ViewStockBE> listGeneralProductForm() throws SQLException, Exception {
		WebService WebService = new WebService();
		List<ViewStockBE> listFormmain = WebService.listGeneralProductForm(1);
		return listFormmain;
	}

	@PostMapping("/GuardarProductos")
	public ModelEntities GuardarProductos(@RequestBody Producto pro) {
		WebService WebService = new WebService();
		return WebService.listaProductos();
	}

	@PostMapping("/InsertStock")
	public List<Stock> InsertStock(@RequestBody Stock stock) {
		WebService WebService = new WebService();
		return WebService.InsertStock(stock);
	}

	@PostMapping("/ListProduct")
	public List<Producto> ListProduct(@RequestBody String keySearch) {
		WebService WebService = new WebService();
		return WebService.ListProduct();
	}

	// Methot return entity
// @PostMapping("/ListImagenByIdProduct")
	@PostMapping(path = "/ListImagenByIdProduct", consumes = "application/json", produces = "application/json")
	public List<HomeViewModel> ListImagenByIdProduct(@RequestBody Producto pro) {
		WebService WebService = new WebService();
		return WebService.ListImagenByIdProduct(pro);
	}

	@PostMapping(path = "/ListDetImagenByIdProduct", consumes = "application/json", produces = "application/json")
	public List<HomeViewModel> ListDetImagenByIdProduct(@RequestBody Producto pro) {
		WebService WebService = new WebService();
		return WebService.ListDetImagenByIdProduct(pro);
	}

	@PostMapping(path = "/ImagenSel", consumes = "application/json", produces = "application/json")
	public Imagen ImagenSel(@RequestBody Imagen img) {
		WebService WebService = new WebService();
		return WebService.ImagenSel(img);
	}

	@PostMapping(path = "/ProductoSel", consumes = "application/json", produces = "application/json")
	public Producto ProductoSel(@RequestBody Producto pro) {
		WebService WebService = new WebService();
		return WebService.ProductoSel(pro);
	}

	@PostMapping(path = "/ListDetImagenByIdImagen", consumes = "application/json", produces = "application/json")
	public List<HomeViewModel> ListDetImagenByIdImagen(@RequestBody Imagen img) {
		WebService WebService = new WebService();
		return WebService.ListDetImagenByIdImagen(img);
	}

	@PostMapping(path = "/HomeViewModelSelByIdDroducto", consumes = "application/json", produces = "application/json")
	public HomeViewModel HomeViewModelSelByIdDroducto(@RequestBody Producto pro) {
		WebService WebService = new WebService();
		return WebService.HomeViewModelSelByIdDroducto(pro);
	}

	@PostMapping(path = "/DetailProductIns", consumes = "application/json", produces = "application/json")
	public boolean DetailProductIns(@RequestBody Detailproduct pro) {
		WebService WebService = new WebService();
		return WebService.DetailProductIns(pro);
	}

	@PostMapping(path = "/ListDetailProductByIdProduct", consumes = "application/json", produces = "application/json")
	public List<Detailproduct> ListDetailProductByIdProduct(@RequestBody Detailproduct pro) {
		WebService WebService = new WebService();
		return WebService.ListDetailProductByIdProduct(pro);
	}

	@PostMapping(path = "/ListDetailProductIns", consumes = "application/json", produces = "application/json")
	public boolean ListDetailProductIns(@RequestBody Detailproduct[] pro) {
		for (Detailproduct detailproduct : pro) {
			WebService WebService = new WebService();
			return WebService.DetailProductIns(detailproduct);
		}
		return false;
	}

}
