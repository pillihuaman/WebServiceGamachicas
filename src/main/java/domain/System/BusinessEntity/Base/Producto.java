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
	private int idclothing;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdclothing() {
		return idclothing;
	}

	public int getIdimagen() {
		return Idimagen;
	}

	public int getIdstock() {
		return idstock;
	}

	public void setIdclothing(int idclothing) {
		this.idclothing = idclothing;
	}

	public void setIdimagen(int idimagen) {
		Idimagen = idimagen;
	}

	public void setIdstock(int idstock) {
		this.idstock = idstock;
	}

	private int Idimagen;
	private int idstock;


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



}