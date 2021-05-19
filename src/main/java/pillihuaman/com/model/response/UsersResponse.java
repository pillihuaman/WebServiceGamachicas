package pillihuaman.com.model.response;

import java.util.List;

import pillihuaman.com.BusinessEntity.Base.Response;
import pillihuaman.com.BusinessEntity.Base.Users;


public class  UsersResponse extends Response {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 public Users getUsers() {
		return users;
	}
	public List<Users> getListUsers() {
		return listUsers;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public void setListUsers(List<Users> listUsers) {
		this.listUsers = listUsers;
	}
private Users users;
 private List<Users> listUsers;
	
}
