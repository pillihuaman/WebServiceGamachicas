package common.system.model.response;

import java.util.List;

import domain.System.BusinessEntity.Base.Response;
import domain.System.BusinessEntity.Base.Users;


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
