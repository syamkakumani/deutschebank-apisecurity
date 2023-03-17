package com.nobleprod.sec;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@GetMapping("/person-info")
	String personInfo() {
		return "Syam Kakumani, <font color = 'green'>India</font>";
	}
}
