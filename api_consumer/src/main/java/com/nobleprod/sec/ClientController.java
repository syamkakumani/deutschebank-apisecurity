package com.nobleprod.sec;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

	
	@RequestMapping("/client/{clientName}")
	String welcomeClient(@PathVariable  String clientName){
		
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<String> encrptionResponse = template.postForEntity("http://localhost:1111/encrypt", clientName, String.class);
		System.out.println("Encyption of ("+clientName+") - "+encrptionResponse);
		
		ResponseEntity<String> providerResponse = template.postForEntity("http://localhost:9090/greet", encrptionResponse, String.class);
		
		return providerResponse.getBody();
		
	}
}
