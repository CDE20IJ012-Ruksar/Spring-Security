package com.cognizant;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	private final GreetingService service;

	public GreetController(GreetingService service) {
		super();
		this.service = service;
	}
	
	@RequestMapping("/greet")
	public @ResponseBody String greeting() {
		return service.greet();
	}
}
