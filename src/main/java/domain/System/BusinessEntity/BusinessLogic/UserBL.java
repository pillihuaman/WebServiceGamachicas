package domain.System.BusinessEntity.BusinessLogic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import common.system.model.response.UsersResponse;
import common.system.security.PasswordUtils;
import domain.System.BusinessEntity.Base.Users;
import repository.System.DataAccess.MySql.UserDA;
import common.system.security.BcryptManager;

public class UserBL {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(UserBL.class);
	@SuppressWarnings("unused")
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

	public static UsersResponse UserSelByMail(Users users) {
		return UserDA.UserSelByMail(users);

	}

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

	}

}
