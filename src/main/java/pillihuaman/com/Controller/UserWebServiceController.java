package pillihuaman.com.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pillihuaman.com.BusinessEntity.Base.*;
import pillihuaman.com.Log.Log4J2PropertiesConf;
import pillihuaman.com.Service.IUserService;
import pillihuaman.com.dao.IUserDAO;
import pillihuaman.com.model.response.PriceResponse;
import pillihuaman.com.model.response.ProductoResponse;
import pillihuaman.com.model.response.UsersResponse;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("userService")
public class UserWebServiceController {
	@Autowired
	private IUserService UserServi;
	private static Logger logger =  LogManager.getLogger();
	@PostMapping("/usersIns")
	public UsersResponse UsersIns(@RequestBody Users users) {
		logger.warn("/usersIns"+users);
		return UserServi.UsersIns(users);
	}
	/*
	@PostMapping("/userSel")
	public UsersResponse UserSel(@RequestBody Users users) {
		UsersRepository WebService = new UsersRepository();
		return WebService.UsersSel(users);
	}
	@PostMapping("/userSelByMail")
	public UsersResponse UserSelByMail(@RequestBody Users users) {
		UsersRepository WebService = new UsersRepository();
		return WebService.UsersSel(users);
	}
	@PostMapping("/logIng")
	public UsersResponse LogIng(@RequestBody Users users) {
		UsersRepository WebService = new UsersRepository();
		return WebService.LogIng(users);
	}
	


//	@PostMapping("/UserDel")
//	public UsersResponse InsertStock(@RequestBody Stock stock) {
//		WebService WebService = new WebService();
//		return WebService.InsertStock(stock);
//
//	}*/
}
