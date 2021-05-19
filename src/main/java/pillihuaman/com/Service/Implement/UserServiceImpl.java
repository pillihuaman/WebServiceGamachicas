package pillihuaman.com.Service.Implement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import pillihuaman.com.BusinessEntity.Base.Users;
import pillihuaman.com.Service.IUserService;
import pillihuaman.com.dao.IUserDAO;
import pillihuaman.com.model.response.UsersResponse;
import pillihuaman.com.security.BcryptManager;
import pillihuaman.com.security.PasswordUtils;

import org.springframework.stereotype.Service;

 @Service
public class UserServiceImpl implements IUserService {
	 
		@Autowired
		private IUserDAO UserDAO;
		
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(UserServiceImpl.class);
   
	/*@SuppressWarnings("unused")
	public static UsersResponse UsersIns(Users users) {
		UsersResponse detail = new UsersResponse();
		try {
			// validamos si existe el correo
			detail = UserSelByMail(users);
			detail.setFullpath("UserBL/UsersIns");
			if (detail.getUsers() == null) {
				String password = users.getPassword();
				String salt = PasswordUtils.getSalt(30);
				String mySecurePassword = PasswordUtils.generateSecurePassword(password, salt);
				users.setApiPassword(new BCryptPasswordEncoder().encode(password));
				users.setPassword(mySecurePassword);
				users.setSalPassword(salt);
				return UserDA.UsersIns(users);
			} else {
				detail.setCode(200);
				detail.setDescription("El" + users.getMail() + " ya esta registrado.");
				detail.setMessage("Warring");
				detail.getListUsers().clear();
				detail.setUsers(null);
				// detail.setUsers(users);
				return detail;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			detail.setCode(500);
			detail.setDescription(e.getMessage());
			detail.setMessage("Error Inesperado");
			detail.setUsers(users);
			logger.error(detail.getFullpath(),detail.getDescription());
			return detail;
		}
	}
	
	 */


/*
	public static UsersResponse LogIng(Users users) {
		UsersResponse detail = new UsersResponse();
		String passwordRequest=users.getPassword();
		try {
			// validamos si existe el correo
			detail = UserSelByMail(users);
			
			detail.setFullpath("UserBL/LogIng");
			if (detail.getUsers() != null) {
				boolean mySecurePassword = PasswordUtils.verifyUserPassword(passwordRequest,
						detail.getUsers().getPassword(), detail.getUsers().getSalPassword());
				if (mySecurePassword == true) {
					return detail;
				} else {
					detail.setCode(200);
					detail.setDescription("La contraseña es incorrecta");
					detail.setMessage("Warring");
					detail.getListUsers().clear();
					detail.setUsers(null);
					// detail.setUsers(users);
					return detail;

				}
			} else {
				detail.setCode(200);
				detail.setDescription("El correo" + users.getMail() + " No está registrado");
				detail.setMessage("Warring");
				detail.getListUsers().clear();
				detail.setUsers(null);
				// detail.setUsers(users);
				return detail;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			detail.setCode(500);
			detail.setDescription(e.getMessage());
			detail.setMessage("Error Inesperado");
			detail.setUsers(users);
			return detail;
		}

	}*/

	
	@Override
	public UsersResponse UsersIns(Users users) {
		UsersResponse userResp = new UsersResponse();
		try {
			// validamos si existe el correo
			userResp = UserSelByMail(users);
			userResp.setFullpath("UserBL/UsersIns");
			if (userResp.getUsers() == null) {
				String password = users.getPassword();
				String salt = PasswordUtils.getSalt(30);
				String mySecurePassword = PasswordUtils.generateSecurePassword(password, salt);
				users.setApiPassword(new BCryptPasswordEncoder().encode(password));
				users.setPassword(mySecurePassword);
				users.setSalPassword(salt);
				
				
				
				return UserDAO.UsersIns(users);
			} else {
				userResp.setCode(200);
				userResp.setDescription("El" + users.getMail() + " ya esta registrado.");
				userResp.setMessage("Warring");
				userResp.getListUsers().clear();
				userResp.setUsers(null);
				// detail.setUsers(users);
				return userResp;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			userResp.setCode(500);
			userResp.setDescription(e.getMessage());
			userResp.setMessage("Error Inesperado");
			userResp.setUsers(users);
			logger.error(userResp.getFullpath(),userResp.getDescription());
		}
		return userResp;
			
	}

	@Override
	public UsersResponse UsersSel(Users users) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsersResponse UserSelByMail(Users users) {
		return UserDAO.UserSelByMail(users);
	}

	@Override
	public UsersResponse LogIng(Users users) {
		// TODO Auto-generated method stub
		return null;
	}

}
