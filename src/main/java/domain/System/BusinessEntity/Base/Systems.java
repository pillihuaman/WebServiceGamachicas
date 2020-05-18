package domain.System.BusinessEntity.Base;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the system database table.
 * 
 */
@Entity
@NamedQuery(name="Systems.findAll", query="SELECT s FROM Systems s")
public class Systems implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSystem;

	private Timestamp createDate;

	private String idCompany;

	private int idmenu;

	private String name;

	private byte status;

	private Timestamp updateDate;

	private String url;

	public Systems() {
	}

	public int getIdSystem() {
		return this.idSystem;
	}

	public void setIdSystem(int idSystem) {
		this.idSystem = idSystem;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getIdCompany() {
		return this.idCompany;
	}

	public void setIdCompany(String idCompany) {
		this.idCompany = idCompany;
	}

	public int getIdmenu() {
		return this.idmenu;
	}

	public void setIdmenu(int idmenu) {
		this.idmenu = idmenu;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

}