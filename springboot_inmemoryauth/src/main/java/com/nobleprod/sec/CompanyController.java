package com.nobleprod.sec;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

	@GetMapping("/company-data")
	String getCompanyInfo() {
		return "Noble Prog, Romania"; 
	}
}
