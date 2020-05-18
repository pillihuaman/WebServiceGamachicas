package model.system.Abstract;

import common.system.model.response.ImagenResponse;
import common.system.model.response.UsersResponse;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Users;

public interface IUsers {

	UsersResponse UsersIns( Users  users);
	UsersResponse UsersSel( Users  users);
	UsersResponse UserSelByMail( Users  users);
	UsersResponse LogIng( Users  users);
}
