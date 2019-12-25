package common.system.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import common.system.ViewModel.ListImagenByIdProductModelAndView;
import common.system.ViewModel.ModelEntities;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Producto;
import domain.System.BusinessEntity.Base.Stock;
import model.system.Abstract.IWebService;
import model.system.repository.WebService;

@RestController
@RequestMapping("WebService")
public class WebServiceController
{
	//parte del repositorio
	//@Autowired
	//private IWebService pro;
@GetMapping(value = "/ListaProducto", produces = "application/json; charset=UTF-8")
 //@GetMapping("/ListaProducto",produces ="")
 public  ModelEntities ListaProducto()
 {
	 WebService WebService = new WebService();
	 ModelEntities list = WebService.listaProductos();
	return  list;
 }
@GetMapping(value = "/listGeneralProductForm", produces = "application/json; charset=UTF-8")
//@GetMapping("/ListaProducto",produces ="")
public  List<ViewStockBE> listGeneralProductForm() throws SQLException, Exception
{
	 WebService WebService = new WebService();
	 List<ViewStockBE>  listFormmain = WebService.listGeneralProductForm(1);
	return  listFormmain;
}
 @PostMapping("/GuardarProductos")
 public ModelEntities GuardarProductos(@RequestBody Producto pro)
 {
	 WebService WebService = new WebService();
	return WebService.listaProductos();
 }
 
 @PostMapping("/InsertStock")
 public List<Stock> InsertStock(@RequestBody Stock stock)
 {
	 WebService WebService = new WebService();
	return WebService.InsertStock(stock);
 }
 
 @PostMapping("/ListProduct")
 public List<Producto> ListProduct(@RequestBody String keySearch)
 {
	 WebService WebService = new WebService();
	return WebService.ListProduct();
 }
 //Methot return entity 
// @PostMapping("/ListImagenByIdProduct")
 @PostMapping(path = "/ListImagenByIdProduct", consumes = "application/json", produces = "application/json")
 public ListImagenByIdProductModelAndView ListImagenByIdProduct(@RequestBody Producto pro)
 {
	 WebService WebService = new WebService();
	return WebService.ListImagenByIdProduct(pro);
 }
}
