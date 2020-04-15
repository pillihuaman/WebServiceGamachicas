package domain.System.BusinessEntity.Base;

public class HomeViewModel {
	 public Imagen getImagen() {
		return Imagen;
	}
	public Producto getProducto() {
		return Producto;
	}
	public Price getPrice() {
		return Price;
	}
	public Detailimagen getDetailimagen() {
		return Detailimagen;
	}
	public void setImagen(Imagen imagen) {
		Imagen = imagen;
	}
	public void setProducto(Producto producto) {
		Producto = producto;
	}
	public void setPrice(Price price) {
		Price = price;
	}
	public void setDetailimagen(Detailimagen detailimagen) {
		Detailimagen = detailimagen;
	}
	 private  Imagen Imagen;
	 private  Producto Producto;
	 private Price Price;
	 private  Detailimagen Detailimagen;
	

    
}
