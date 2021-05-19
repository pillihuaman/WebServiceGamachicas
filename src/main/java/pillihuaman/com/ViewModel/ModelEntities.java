package pillihuaman.com.ViewModel;

import java.util.List;

import pillihuaman.com.BusinessEntity.Base.Product;

public class ModelEntities {
	public List<Product> getListaProducto() {
		return listaProducto;
	}
	public void setListaProducto(List<Product> listaProducto) {
		this.listaProducto = listaProducto;
	}

	private  List<Product> listaProducto ;
	

}
