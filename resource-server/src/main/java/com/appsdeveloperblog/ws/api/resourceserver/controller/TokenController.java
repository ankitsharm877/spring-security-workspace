package com.appsdeveloperblog.ws.api.resourceserver.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {
	
	@GetMapping
	public Map<String, Jwt> getToken(@AuthenticationPrincipal Jwt jwt) {
		//return jwt;
		return Collections.singletonMap("principle", jwt);
	}
}
