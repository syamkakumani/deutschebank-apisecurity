package com.nobleprod.sec;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

	@GetMapping("/info")
	String info() {
		return "NobleProg, Germany !!";
	}

	@GetMapping(value = "/info", params = "api-ver=2")
	String newInfo() {
		return "Version 2 --- NobleProg, Germany !!";
	}
}
