package domain.System.BusinessEntity;

import domain.System.BusinessEntity.Base.*;

public class ViewProductBE {
	   public Producto getProducto() {
		return Producto;
	}
	public void setProducto(Producto producto) {
		Producto = producto;
	}
	public Price getPrice() {
		return Price;
	}
	public void setPrice(Price price) {
		Price = price;
	}
	public Clothing getClothing() {
		return Clothing;
	}
	public void setClothing(Clothing clothing) {
		Clothing = clothing;
	}
	public Color getColor() {
		return Color;
	}
	public void setColor(Color color) {
		Color = color;
	}
	public Imagen getImagen() {
		return Imagen;
	}
	public void setImagen(Imagen imagen) {
		Imagen = imagen;
	}
	public Stock getStock() {
		return Stock;
	}
	public void setStock(Stock stock) {
		Stock = stock;
	}
	   private Producto Producto ;
	   private Price Price ;
	   private Clothing Clothing ;
	   private Color Color ;
	   private Imagen Imagen ;
	   private Stock Stock ;
	   private Clothingline Clothingline;
	   public Clothingline getClothingline() {
		return Clothingline;
	}
	public void setClothingline(Clothingline clothingline) {
		Clothingline = clothingline;
	}

	  
}
