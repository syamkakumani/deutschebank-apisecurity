package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingClient {

	@GetMapping("/express-greetings/{nm}")
	void greetAccess(@PathVariable("nm") String greetedPerson) {
		StringBuffer sb = new StringBuffer();

		while (true) {
			RestTemplate template = new RestTemplate();
			ResponseEntity<String> res = template
					.getForEntity("http://localhost:8080/greetings/" + greetedPerson + "/999999999", String.class);

			System.out.println("avaialble mem : " + Runtime.getRuntime().freeMemory());

		}

	}

}
