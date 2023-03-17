package com.nobleprod.sec;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddreController {
	
	CommonOAuth2Provider co;

	Map<String, String> countries = new HashMap<>() {
		{
			put("bangalore", "India");
			put("bucharest", "Romania");
		}
	};

	@GetMapping("/country/{city}")
	String getCountry(@PathVariable String city) {
		return city + "is in (" + countries.get(city) + ")";
	}

	@GetMapping("/logged-user")
	OidcUser uerInfo(@AuthenticationPrincipal OidcUser user) {
		return user;
	}

}
