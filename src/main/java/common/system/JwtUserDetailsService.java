package common.system;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import common.system.model.response.UsersResponse;
import common.system.security.VerifyProvidedPassword;
import domain.System.BusinessEntity.Base.Users;
import domain.System.BusinessEntity.BusinessLogic.UserBL;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users use = new Users();
		UsersResponse usersMa = new UsersResponse();
		use.setMail(username);
		usersMa = UserBL.UserSelByMail(use);
		// Validamos si existe para generarle un toquen
//		boolean validate = VerifyProvidedPassword.PasswordVerify(usersMa.getUsers().getPassword(),
//				usersMa.getUsers().getPassword(), usersMa.getUsers().getSalPassword());
//		if (validate == true) {
			if (usersMa.getUsers() != null) {

				return new org.springframework.security.core.userdetails.User(usersMa.getUsers().getMail(), usersMa.getUsers().getApiPassword(),
						new ArrayList<>());
				
			} else {
				throw new UsernameNotFoundException("Users not found with username: " + username);
			}
	}
}