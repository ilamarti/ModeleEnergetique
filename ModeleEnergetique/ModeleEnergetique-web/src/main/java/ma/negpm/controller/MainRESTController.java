package ma.negpm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRESTController {

	@RequestMapping("/me")
	@ResponseBody
	public String welcome() {
		return "Welcome to Spring Boot + REST + JWT Example.";
	}

}
