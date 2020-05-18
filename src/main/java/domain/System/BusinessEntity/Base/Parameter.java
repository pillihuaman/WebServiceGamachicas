package domain.System.BusinessEntity.Base;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the parameter database table.
 * 
 */
@Entity
@NamedQuery(name="Parameter.findAll", query="SELECT p FROM Parameter p")
public class Parameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idparameter;

	private Timestamp createdate;

	private String description;

	private int idGroupparameter;

	private String name;

	private boolean status;

	private Timestamp updatedate;

	private String value;

	public Parameter() {
	}

	public int getIdparameter() {
		return this.idparameter;
	}

	public void setIdparameter(int idparameter) {
		this.idparameter = idparameter;
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

	public int getIdGroupparameter() {
		return this.idGroupparameter;
	}

	public void setIdGroupparameter(int idGroupparameter) {
		this.idGroupparameter = idGroupparameter;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Timestamp getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}