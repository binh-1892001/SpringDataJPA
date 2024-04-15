package com.ra.controller;

import com.ra.model.Users;
import com.ra.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
	private final UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody Users users) {
		return new ResponseEntity<>(userService.save(users), HttpStatus.CREATED);
	}
	
}
