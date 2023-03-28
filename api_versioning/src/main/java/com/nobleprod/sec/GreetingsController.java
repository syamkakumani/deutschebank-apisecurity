package com.nobleprod.sec;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	@GetMapping("/api/v1/greet")
	String greet() {
		return "Seasonal Greetings !!";
	}
	
	
	@GetMapping("/api/v2/greet")
	String seasonalGreet() {
		return "V2 --- Seasonal Greetings !!";
	}
}
