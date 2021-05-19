package pillihuaman.com.BusinessEntity.Base;

public class HomeViewModel extends Response {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Imagen getImagen() {
		return imagen;
	}
	public Product getProducto() {
		return product;
	}
	public Price getPrice() {
		return price;
	}
	public Detailimagen getDetailImagen() {
		return detailImagen;
	}
	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}
	public void setProducto(Product producto) {
		this.product = producto;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public void setDetailImagen(Detailimagen detailImagen) {
		this.detailImagen = detailImagen;
	}
	private Imagen imagen;
	private Product product;
	private Price price;
	private Detailimagen detailImagen;

}
