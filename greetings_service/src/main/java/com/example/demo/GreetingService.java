package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingService {

	@GetMapping("/greetings/{name}/{mem}")
	String greet(@PathVariable String name, @PathVariable Integer mem) {
		long[] allocateData = new long[mem];
		
		return "Dear <b><font color='blue'>" + name + "</font></b>, Seasonal Greetings !!";
	}
}
