package common.system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import common.system.model.response.HomeViewModelResponse;
import common.system.model.response.ProductoResponse;
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Product;
import model.system.repository.ProductRepository;
import model.system.repository.WebService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("WebServiceProduct")
public class WebServiceProductController {

	@PostMapping("/SaveProduct")
	public ProductoResponse SaveProduct(@RequestBody Product pro) {
		ProductRepository WebService = new ProductRepository();
		return WebService.SaveProduct(pro);
	}

	@PostMapping("/ListProduct")
	public List<Product> ListProduct(@RequestBody String keySearch) {
		ProductRepository WebService = new ProductRepository();
		return WebService.ListProduct();
	}

	@PostMapping(path = "/HomeProductIns", consumes = "application/json", produces = "application/json")
	public HomeViewModelResponse HomeProductIns(@RequestBody HomeViewModel homeViewModel) {
		ProductRepository WebService = new ProductRepository();
		return WebService.HomeProductIns(homeViewModel);
	}

	@PostMapping(path = "/ListDetImagenByIdProduct", consumes = "application/json", produces = "application/json")
	public List<HomeViewModel> ListDetImagenByIdProduct(@RequestBody Product pro) {
		ProductRepository WebService = new ProductRepository();
		return WebService.ListDetImagenByIdProduct(pro);
	}

	@PostMapping(path = "/ProductoSel", consumes = "application/json", produces = "application/json")
	public ProductoResponse ProductoSel(@RequestBody Product pro) {
		ProductRepository WebService = new ProductRepository();
		return WebService.ProductoSel(pro);
	}

	@PostMapping(path = "/HomeViewModelSelByIdDroducto", consumes = "application/json", produces = "application/json")
	public HomeViewModel HomeViewModelSelByIdDroducto(@RequestBody Product pro) {
		ProductRepository WebService = new ProductRepository();
		return WebService.HomeViewModelSelByIdDroducto(pro);
	}

	@PostMapping(path = "/DetailProductIns", consumes = "application/json", produces = "application/json")
	public boolean DetailProductIns(@RequestBody Detailproduct pro) {
		ProductRepository WebService = new ProductRepository();
		return WebService.DetailProductIns(pro);
	}

	@PostMapping(path = "/ListDetailProductByIdProduct", consumes = "application/json", produces = "application/json")
	public List<Detailproduct> ListDetailProductByIdProduct(@RequestBody Detailproduct pro) {
		ProductRepository WebService = new ProductRepository();
		return WebService.ListDetailProductByIdProduct(pro);
	}
}
