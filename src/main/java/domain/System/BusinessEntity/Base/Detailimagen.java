package domain.System.BusinessEntity.Base;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the detailimagen database table.
 * 
 */
@Entity
@NamedQuery(name="Detailimagen.findAll", query="SELECT d FROM Detailimagen d")
public class Detailimagen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idDetailImagen;

	private Timestamp createDate;

	private int idImagen;

	private byte status;

	private Timestamp updateDate;

	private String url;

	private int vista;

	public Detailimagen() {
	}

	public int getIdDetailImagen() {
		return this.idDetailImagen;
	}

	public void setIdDetailImagen(int idDetailImagen) {
		this.idDetailImagen = idDetailImagen;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public int getIdImagen() {
		return this.idImagen;
	}

	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getVista() {
		return this.vista;
	}

	public void setVista(int vista) {
		this.vista = vista;
	}

}