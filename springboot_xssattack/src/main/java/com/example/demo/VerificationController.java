package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationController {

	@GetMapping("/check")
	String checkService() {
		return "Service is working ...";
	}
}
