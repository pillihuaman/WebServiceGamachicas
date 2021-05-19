package pillihuaman.com.Service;

import pillihuaman.com.BusinessEntity.Base.Users;
import pillihuaman.com.model.response.UsersResponse;

public interface IUserService {

	UsersResponse UsersIns( Users  users);
	UsersResponse UsersSel( Users  users);
	UsersResponse UserSelByMail( Users  users);
	UsersResponse LogIng( Users  users);
}
