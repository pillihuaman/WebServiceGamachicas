package domain.System.BusinessEntity.Base;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the price database table.
 * 
 */
@Entity
@NamedQuery(name="Price.findAll", query="SELECT p FROM Price p")
public class Price implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idprecio;

	private Timestamp createdate;

	private int idclothing;

	private int idproducto;

	private Double preciomayor;

	private Double preciomenor;

	private byte status;

	private Timestamp updatedate;

	public Price() {
	}

	public int getIdprecio() {
		return this.idprecio;
	}

	public void setIdprecio(int idprecio) {
		this.idprecio = idprecio;
	}

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public int getIdclothing() {
		return this.idclothing;
	}

	public void setIdclothing(int idclothing) {
		this.idclothing = idclothing;
	}

	public int getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public Double getPreciomayor() {
		return this.preciomayor;
	}

	public void setPreciomayor(Double preciomayor) {
		this.preciomayor = preciomayor;
	}

	public Double getPreciomenor() {
		return this.preciomenor;
	}

	public void setPreciomenor(Double preciomenor) {
		this.preciomenor = preciomenor;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Timestamp getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

}