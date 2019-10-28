package common.system.ViewModel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackageClasses = {Application.class})
@SpringBootApplication
public class Application   {

	
	//@Override
	//protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		//return application.sources(Application.class);
	//}
	
	public static void main(String[] args) {
		//SpringApplication app = new SpringApplication(Application.class);
        //app.setDefaultProperties(Collections
          //.singletonMap("server.port", "8089"));
        //app.run(args);
        
	SpringApplication.run(Application.class, args);
	}


}


