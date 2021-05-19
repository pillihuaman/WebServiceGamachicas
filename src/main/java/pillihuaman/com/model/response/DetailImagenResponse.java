package pillihuaman.com.model.response;

import java.util.List;

import pillihuaman.com.BusinessEntity.Base.Detailimagen;
import pillihuaman.com.BusinessEntity.Base.Response;

public class DetailImagenResponse  extends Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Detailimagen getDetailImagen() {
		return detailImagen;
	}
	public List<Detailimagen> getLstDetailimagen() {
		return lstDetailimagen;
	}
	public void setDetailImagen(Detailimagen detailImagen) {
		this.detailImagen = detailImagen;
	}
	public void setLstDetailimagen(List<Detailimagen> lstDetailimagen) {
		this.lstDetailimagen = lstDetailimagen;
	}
	private Detailimagen detailImagen;
	private List<Detailimagen> lstDetailimagen;

}
