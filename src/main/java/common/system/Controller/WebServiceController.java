package common.system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.System.BusinessEntity.Base.Producto;
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
 public Producto ListaProducto()
 {
	 WebService WebService = new WebService();
	  List<Producto> list = WebService.listaProductos();
	return  (Producto) list.get(0);
 }
 @PostMapping("/GuardarProductos")
 public List<Producto> GuardarProductos(@RequestBody Producto pro)
 {
	 WebService WebService = new WebService();
	return WebService.listaProductos();
 }
}
