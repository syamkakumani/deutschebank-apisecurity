package com.nobleprod.sec;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@GetMapping(value = "/person-info", produces = "application/noble-1.json")
	String personalInfo(){
		return "Syam Kakumani";
	}
	
	@GetMapping(value = "/person-info", produces = "application/noble-2.json")
	String personalInformation(){
		return "Elena Popov";
	}
}
