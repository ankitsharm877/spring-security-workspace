package com.appsdeveloperblog.ws.api.resourceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.ws.api.resourceserver.model.User;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	Environment environment;

	@GetMapping("/status/check")
	public String status() {
		return "Running on port: " + environment.getProperty("local.server.port");
	}
	
	@Secured("ROLE_developer")
	@DeleteMapping(path = "/delete/{id}")
	public String deleteUser(@PathVariable String id) {
		return "Deleted user with id: " + id;
	}

	//@PreAuthorize("hasRole('developer')")
	@PreAuthorize("hasAuthority('ROLE_developer') or #id == #jwt.subject")
	@DeleteMapping(path = "/deletePreAuthorize/{id}")
	public String deleteUserPreAuthorize(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
		return "Deleted user with id: " + id + " and JWT subject: " + jwt.getSubject();
	}
	
	@PostAuthorize("returnObject.userid == #jwt.subject")
	@GetMapping(path = "/getUserPostAuthorize/{id}")
	public User getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
		return new User("Ankit", "Sharma", "87c59696-f808-43ff-b42e-778eac35d096");
	}

}
