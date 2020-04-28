package ma.negpm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MainRESTController {

	@PostMapping("/me")
	@ResponseBody
	public String welcome() {
		return "Welcome to Spring Boot + REST + JWT Example.";
	}
    
	
	
}
