package common.system.ViewModel;

import java.util.List;

import domain.System.BusinessEntity.Base.Producto;

public class ModelEntities {
	public List<Producto> getListaProducto() {
		return listaProducto;
	}
	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	private  List<Producto> listaProducto ;
	

}
