package pillihuaman.com.BusinessEntity.Base;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the imagen database table.
 * 
 */
@Entity
@NamedQuery(name="Imagen.findAll", query="SELECT i FROM Imagen i")
public class Imagen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idImagen;

	private int countViews;

	private Timestamp createdate;

	private String description;

	private int idProduct;

	private int idSystem;

	private int idUser;

	private String imagenCode;

	@Lob
	private byte[] imagendata;

	private String name;

	private int positionWeb;

	private byte status;

	private Timestamp updatedate;

	private String url;

	public Imagen() {
	}

	public int getIdImagen() {
		return this.idImagen;
	}

	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}

	public int getCountViews() {
		return this.countViews;
	}

	public void setCountViews(int countViews) {
		this.countViews = countViews;
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

	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getIdSystem() {
		return this.idSystem;
	}

	public void setIdSystem(int idSystem) {
		this.idSystem = idSystem;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getImagenCode() {
		return this.imagenCode;
	}

	public void setImagenCode(String imagenCode) {
		this.imagenCode = imagenCode;
	}

	public byte[] getImagendata() {
		return this.imagendata;
	}

	public void setImagendata(byte[] imagendata) {
		this.imagendata = imagendata;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPositionWeb() {
		return this.positionWeb;
	}

	public void setPositionWeb(int positionWeb) {
		this.positionWeb = positionWeb;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}