package model.system.repository;

import common.system.model.response.UsersResponse;
import domain.System.BusinessEntity.Base.Users;
import domain.System.BusinessEntity.BusinessLogic.UserBL;
import model.system.Abstract.IUsers;

public class UsersRepository implements IUsers {

	@Override
	public UsersResponse UsersIns(Users users) {
		// TODO Auto-generated method stub
		return  UserBL.UsersIns(users);
	}

//	@Override
//	public UsersResponse UsersSel(Users users) {
//		// TODO Auto-generated method stub
//		return  UserBL.UsersSel(users);
//	}

	@Override
	public UsersResponse UserSelByMail(Users users) {
		// TODO Auto-generated method stub
		return  UserBL.UserSelByMail(users);
	}

	@Override
	public UsersResponse UsersSel(Users users) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsersResponse LogIng(Users users) {
		// TODO Auto-generated method stub
		return  UserBL.LogIng(users);
	}

}
