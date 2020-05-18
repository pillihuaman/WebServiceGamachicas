package common.system.model.response;

import java.util.List;

import domain.System.BusinessEntity.Base.Customers;
import domain.System.BusinessEntity.Base.Response;

public class CustomersResponse extends Response {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Customers getCustomers() {
		return customers;
	}
	public List<Customers> getListCustomer() {
		return listCustomer;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	public void setListCustomer(List<Customers> listCustomer) {
		this.listCustomer = listCustomer;
	}
	private  Customers customers;
	private List<Customers> listCustomer ;

}
