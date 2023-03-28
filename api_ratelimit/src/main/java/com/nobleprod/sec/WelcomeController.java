package com.nobleprod.sec;

import java.time.Duration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;

@RestController
public class WelcomeController {

	private final Bucket bucket;

	public WelcomeController() {
		Bandwidth limit = Bandwidth.classic(5, Refill.greedy(5, Duration.ofMinutes(1)));
		this.bucket = Bucket4j.builder().addLimit(limit).build();
	}

	@GetMapping("/welcome/{user}")
	ResponseEntity<String> welcomeMessage(@PathVariable("user") String name) {
		if (bucket.tryConsume(1))
			return ResponseEntity.ok("Welcome " + name);

		return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
	}

}
