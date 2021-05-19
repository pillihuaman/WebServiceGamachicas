package pillihuaman.com.BusinessEntity.Base;

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
	private int idPrice;

	private Timestamp createDate;

	private BigDecimal higherPrice;

	private int idProduct;

	private BigDecimal smallerPrice;

	private byte status;

	private Timestamp updateDate;

	public Price() {
	}

	public int getIdPrice() {
		return this.idPrice;
	}

	public void setIdPrice(int idPrice) {
		this.idPrice = idPrice;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public BigDecimal getHigherPrice() {
		return this.higherPrice;
	}

	public void setHigherPrice(BigDecimal higherPrice) {
		this.higherPrice = higherPrice;
	}

	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public BigDecimal getSmallerPrice() {
		return this.smallerPrice;
	}

	public void setSmallerPrice(BigDecimal smallerPrice) {
		this.smallerPrice = smallerPrice;
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

}