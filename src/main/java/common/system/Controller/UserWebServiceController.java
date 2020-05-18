package common.system.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import common.system.Log.Log4J2PropertiesConf;
import common.system.model.response.PriceResponse;
import common.system.model.response.ProductoResponse;
import common.system.model.response.UsersResponse;
import domain.System.BusinessEntity.Base.*;
import model.system.repository.UsersRepository;
import model.system.repository.WebService;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("userService")
public class UserWebServiceController {
	private static Logger logger =  LogManager.getLogger();
	@PostMapping("/usersIns")
	public UsersResponse UsersIns(@RequestBody Users users) {
		UsersRepository WebService = new UsersRepository();
	    logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
		return WebService.UsersIns(users);
	}
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
//	}
}
