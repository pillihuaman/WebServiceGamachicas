package pillihuaman.com.dao;

import pillihuaman.com.BusinessEntity.Base.Users;
import pillihuaman.com.model.response.UsersResponse;

public interface IUserDAO {
	  UsersResponse UsersIns(Users users) ;

	  UsersResponse UsersUpd(Users users);
	  UsersResponse usersDel(Users users);
      UsersResponse UserSelByMail(Users users);
	  UsersResponse UserSel(Users users);


}
