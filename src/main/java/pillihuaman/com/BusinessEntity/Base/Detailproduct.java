package pillihuaman.com.BusinessEntity.Base;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the detailproduct database table.
 * 
 */
@Entity
@NamedQuery(name="Detailproduct.findAll", query="SELECT d FROM Detailproduct d")
public class Detailproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idDetailProduct;

	private Timestamp createdate;

	private String description;

	private int idProducto;

	private String tipo;

	private Timestamp updatedate;

	public Detailproduct() {
	}

	public int getIdDetailProduct() {
		return this.idDetailProduct;
	}

	public void setIdDetailProduct(int idDetailProduct) {
		this.idDetailProduct = idDetailProduct;
	}

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Timestamp getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

}