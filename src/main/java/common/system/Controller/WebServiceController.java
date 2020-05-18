package common.system.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import common.system.model.response.*;
import domain.System.BusinessEntity.Base.*;
import model.system.repository.WebService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("WebService")
public class WebServiceController {

//	@GetMapping(value = "/ListaProducto", produces = "application/json; charset=UTF-8")
//	public ModelEntities ListaProducto() {
//		WebService WebService = new WebService();
//		ModelEntities list = WebService.listaProductos();
//		return list;
//	}

//	@GetMapping(value = "/listGeneralProductForm", produces = "application/json; charset=UTF-8")
//	public List<ViewStockBE> listGeneralProductForm() throws SQLException, Exception {
//		WebService WebService = new WebService();
//		List<ViewStockBE> listFormmain = WebService.listGeneralProductForm(1);
//		return listFormmain;
//	}

	@PostMapping("/SaveProduct")
	public ProductoResponse SaveProduct(@RequestBody Product pro) {
		WebService WebService = new WebService();
		return WebService.SaveProduct(pro);
	}
	@PostMapping("/PriceIns")
	public PriceResponse PriceIns(@RequestBody Price price) {
		WebService WebService = new WebService();
		return WebService.PriceIns(price);
	}
	@PostMapping("/Stockins")
	public boolean InsertStock(@RequestBody Stock stock) {
		WebService WebService = new WebService();
		return WebService.InsertStock(stock);
	}
	@PostMapping("/ListProduct")
	public List<Product> ListProduct(@RequestBody String keySearch) {
		WebService WebService = new WebService();
		return WebService.ListProduct();
	}
	@PostMapping(path = "/ListImagenByIdProduct", consumes = "application/json", produces = "application/json")
	public HomeViewModelResponse ListImagenByIdProduct(@RequestBody Product pro) {
		WebService WebService = new WebService();
		return WebService.ListImagenByIdProduct(pro);
	}
	@PostMapping(path = "/HomeProductIns", consumes = "application/json", produces = "application/json")
	public HomeViewModelResponse  HomeProductIns(@RequestBody HomeViewModel  homeViewModel) {
		WebService WebService = new WebService();
		return WebService.HomeProductIns(homeViewModel);
	}
	@PostMapping(path = "/ListDetImagenByIdProduct", consumes = "application/json", produces = "application/json")
	public List<HomeViewModel> ListDetImagenByIdProduct(@RequestBody Product pro) {
		WebService WebService = new WebService();
		return WebService.ListDetImagenByIdProduct(pro);
	}
	@PostMapping(value  = "/ImagenIns", consumes = "application/json", produces = "application/json")
	public   ImagenResponse ImagenIns(@RequestBody Imagen  Imagen) {
		WebService WebService = new WebService();
		return WebService.ImagenInss(Imagen);
	}
	@PostMapping(path = "/ImagenSel", consumes = "application/json", produces = "application/json")
	public ImagenResponse ImagenSel(@RequestBody Imagen img) {
		WebService WebService = new WebService();
		return WebService.ImagenSel(img);
	}
	@PostMapping(path = "/ProductoSel", consumes = "application/json", produces = "application/json")
	public ProductoResponse ProductoSel(@RequestBody Product pro) {
		WebService WebService = new WebService();
		return WebService.ProductoSel(pro);
	}
	@PostMapping(path = "/ListDetImagenByIdImagen", consumes = "application/json", produces = "application/json")
	public List<HomeViewModel> ListDetImagenByIdImagen(@RequestBody Imagen img) {
		WebService WebService = new WebService();
		return WebService.ListDetImagenByIdImagen(img);
	}
	@PostMapping(path = "/HomeViewModelSelByIdDroducto", consumes = "application/json", produces = "application/json")
	public HomeViewModel HomeViewModelSelByIdDroducto(@RequestBody Product pro) {
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
	@PostMapping(path = "/DetailImagenIns", consumes = "application/json", produces = "application/json")
	public DetailImagenResponse DetailImagenIns(@RequestBody Detailimagen  detailImagen) {
		WebService WebService = new WebService();
		return WebService.DetailImagenIns(detailImagen);
	}

	@PostMapping(path = "/ListDetailProductIns", consumes = "application/json", produces = "application/json")
	public boolean ListDetailProductIns(@RequestBody Detailproduct[] pro) {
		for (Detailproduct detailproduct : pro) {
			WebService WebService = new WebService();
			return WebService.DetailProductIns(detailproduct);
		}
		return false;
	}
	@PostMapping(path = "/MenuList", consumes = "application/json", produces = "application/json")
	public List< Menu> MenuList(@RequestBody Groupparameter  Groupparameter) {
		WebService WebService = new WebService();
		return WebService.MenuList(Groupparameter);
	}	
	@PostMapping(path = "/parentmenuList", consumes = "application/json", produces = "application/json")
	public List<ParentMenu> parentmenuList(@RequestBody ParentMenu  ParentMenu) {
		WebService WebService = new WebService();
		return WebService.parentmenuList(ParentMenu);
	}
	@PostMapping(path = "/Parametersel", consumes = "application/json", produces = "application/json")
	public List<Parameter> Parametersel(@RequestBody Parameter  Parameter) {
		WebService WebService = new WebService();
		return WebService.Parametersel(Parameter);
	}
	


}
