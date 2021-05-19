package pillihuaman.com.BusinessEntity.Base;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the response database table.
 * 
 */
@Entity
@NamedQuery(name="Response.findAll", query="SELECT r FROM Response r")
public class Response implements Serializable {
	private static final long serialVersionUID = 1L;

	private int code;

	private String description;

	private String fullpath;

	private String message;

	public Response() {
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFullpath() {
		return this.fullpath;
	}

	public void setFullpath(String fullpath) {
		this.fullpath = fullpath;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}