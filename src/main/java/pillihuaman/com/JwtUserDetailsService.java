package pillihuaman.com;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pillihuaman.com.BusinessEntity.Base.Users;
import pillihuaman.com.Service.IUserService;
import pillihuaman.com.model.response.UsersResponse;
import pillihuaman.com.security.VerifyProvidedPassword;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @SuppressWarnings("unused")
	@Autowired
	private IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users use = new Users();
		UsersResponse usersMa = new UsersResponse();
		use.setMail(username);
		 usersMa = userService.UserSelByMail(use);
		// Validamos si existe para generarle un toquen
		//boolean validate = VerifyProvidedPassword.PasswordVerify(usersMa.getUsers().getPassword(),
			//	usersMa.getUsers().getPassword(), usersMa.getUsers().getSalPassword());
//		if (validate == true) {

		//if ("pillihuamanhz@gmail.com".equals(username)) {
			//return new User("pillihuamanhz@gmail.com", "$2a$10$uRXfFxgZZ3HA7J7AyjaS8OfAG0gjU3pIu54CYyUTIGJAg5u5Dxs4u",
				//	new ArrayList<>());
			// }

			 if (usersMa.getUsers() != null) {
			 return new
			 org.springframework.security.core.userdetails.User(usersMa.getUsers().getMail(),
			 usersMa.getUsers().getApiPassword(),
			 new ArrayList<>());
		}

		else {
			throw new UsernameNotFoundException("Users not found with username: " + username);
		}

	}
}