package com.nobleprod.sec;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

	
	@GetMapping(value = "/country", headers = "X-DB-Ver=1")
	String getCountry(){
		return "India, Asia";
	}
	
	@GetMapping(value = "/country", headers = "X-DB-Ver=2")
	String getEuropeanCountry(){
		return "Romania, Europe";
	}
}
