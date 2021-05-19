package pillihuaman.com.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pillihuaman.com.BusinessEntity.Base.*;
import pillihuaman.com.model.response.*;


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


//	@PostMapping("/PriceIns")
//	public PriceResponse PriceIns(@RequestBody Price price) {
//		WebService WebService = new WebService();
//		return WebService.PriceIns(price);
//	}
	/*@PostMapping("/Stockins")
	public boolean InsertStock(@RequestBody Stock stock) {
		WebService WebService = new WebService();
		return WebService.InsertStock(stock);
	}
	

	@PostMapping(path = "/ListDetImagenByIdImagen", consumes = "application/json", produces = "application/json")
	public List<HomeViewModel> ListDetImagenByIdImagen(@RequestBody Imagen img) {
		WebService WebService = new WebService();
		return WebService.ListDetImagenByIdImagen(img);
	}
	@PostMapping(path = "/DetailImagenIns", consumes = "application/json", produces = "application/json")
	public DetailImagenResponse DetailImagenIns(@RequestBody Detailimagen  detailImagen) {
		WebService WebService = new WebService();
		return WebService.DetailImagenIns(detailImagen);
	}

//	@PostMapping(path = "/ListDetailProductIns", consumes = "application/json", produces = "application/json")
//	public boolean ListDetailProductIns(@RequestBody Detailproduct[] pro) {
//		for (Detailproduct detailproduct : pro) {
//			WebService WebService = new WebService();
//			return WebService.DetailProductIns(detailproduct);
//		}
//		return false;
//	}
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
	*/


}
