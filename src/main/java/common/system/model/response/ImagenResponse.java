package common.system.model.response;


import java.util.List;

import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Response;

public class ImagenResponse  extends  Response   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Imagen Imagen;
	private List<Imagen> listImagen;
	public List<Imagen> getListImagen() {
		return listImagen;
	}
	public void setListImagen(List<Imagen> listImagen) {
		this.listImagen = listImagen;
	}
	public Imagen getImagen() {
		return Imagen;
	}
	public void setImagen(Imagen imagen) {
		Imagen = imagen;
	}


}
