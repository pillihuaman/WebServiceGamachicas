package pillihuaman.com.BusinessEntity;
import pillihuaman.com.BusinessEntity.Base.*;
public class ViewStockBE {
	   private  Clothing  Clothing;
	   private Color Color;
	   private Clothingline Clothingline;
	   private Detailimagen Detailimagen;
		private  Imagen Imagen;
		private Test Test;
	   public Product getProducto() {
		return Product;
	}

	public void setProducto(Product producto) {
		Product = producto;
	}

	public Stock getStock() {
		return Stock;
	}

	public void setStock(Stock stock) {
		Stock = stock;
	}

	public Price getPrice() {
		return Price;
	}

	public void setPrice(Price price) {
		Price = price;
	}

	private Product Product;
	   private Stock Stock;
	   private Price Price;
	 
      public Detailimagen getDetailimagen() {
		return Detailimagen;
	}

	public void setDetailimagen(Detailimagen detailimagen) {
		Detailimagen = detailimagen;
	}


	   public Imagen getImagen() {
		return Imagen;
	}

	public void setImagen(Imagen imagen) {
		Imagen = imagen;
	}





		public Test getTest() {
		return Test;
	}

	public void setTest(Test test) {
		Test = test;
	}

		/**
	     * @return the Clothing
	     */
	    public Clothing getClothing() {
	        return Clothing;
	    }

	    /**
	     * @param Clothing the Clothing to set
	     */
	    public void setClothing(Clothing Clothing) {
	        this.Clothing = Clothing;
	    }

	    /**
	     * @return the Color
	     */
	    public Color getColor() {
	        return Color;
	    }

	    /**
	     * @param Color the Color to set
	     */
	    public void setColor(Color Color) {
	        this.Color = Color;
	    }

	    /**
	     * @return the Sizes
	     */


	    /**
	     * @return the Clothingline
	     */
	    public Clothingline getClothingline() {
	        return Clothingline;
	    }

	    /**
	     * @param Clothingline the Clothingline to set
	     */
	    public void setClothingline(Clothingline Clothingline) {
	        this.Clothingline = Clothingline;
	    }
	    
	}

