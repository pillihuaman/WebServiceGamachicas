package model.system.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.System.BusinessEntity.Base.Producto;
import domain.System.BusinessEntity.BusinessLogic.WebServiceBL;
import model.system.Abstract.IWebService;
@Service
public class WebService implements IWebService {

	@Override
	public List<Producto> listaProductos() {
		// TODO Auto-generated method stub
		return (List<Producto>) WebServiceBL.listaProductos();
	}

}
