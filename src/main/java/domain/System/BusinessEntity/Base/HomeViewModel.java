package domain.System.BusinessEntity.Base;

public class HomeViewModel extends Response {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public Imagen getImagen() {
		return Imagen;
	}

	public Product getProduct() {
		return Product;
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

	public void setProduct(Product producto) {
		Product = producto;
	}

	public void setPrice(Price price) {
		Price = price;
	}

	public void setDetailimagen(Detailimagen detailimagen) {
		Detailimagen = detailimagen;
	}

	private Imagen Imagen;
	private Product Product;
	private Price Price;
	private Detailimagen Detailimagen;

}
