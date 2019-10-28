package domain.System.BusinessEntity.Base;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idProducto;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Clothing
	@ManyToOne
	@JoinColumn(name="idclothing")
	private Clothing clothing;

	//bi-directional many-to-one association to Imagen
	@ManyToOne
	@JoinColumn(name="Idimagen")
	private Imagen imagen;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="idstock")
	private Stock stock;

	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Clothing getClothing() {
		return this.clothing;
	}

	public void setClothing(Clothing clothing) {
		this.clothing = clothing;
	}

	public Imagen getImagen() {
		return this.imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}