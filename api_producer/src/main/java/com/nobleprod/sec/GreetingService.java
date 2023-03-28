package com.nobleprod.sec;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingService {
	
	// encrypted string

	@PostMapping("/greet")
	ResponseEntity<String> greetUser(@RequestBody String name) {
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> decrptionResponse = template.postForEntity("http://localhost:1111/decrypt", name, String.class);
		
		return ResponseEntity.ok("Welcome Dear." + decrptionResponse.getBody());
	}
}
