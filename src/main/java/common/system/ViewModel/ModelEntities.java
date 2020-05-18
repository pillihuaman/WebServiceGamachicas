package common.system.ViewModel;

import java.util.List;

import domain.System.BusinessEntity.Base.Product;

public class ModelEntities {
	public List<Product> getListaProducto() {
		return listaProducto;
	}
	public void setListaProducto(List<Product> listaProducto) {
		this.listaProducto = listaProducto;
	}

	private  List<Product> listaProducto ;
	

}
