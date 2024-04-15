package com.ra.controller;

import com.ra.model.Users;
import com.ra.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("")
	public ResponseEntity<List<Users>> index() {
		return ResponseEntity.ok(userService.findAll());
	}
	
	@GetMapping("/add")
	public String viewAdd(Model model) {
		model.addAttribute("user", new Users());
		return "addUser";
	}
	
	@PostMapping("/add")
	public String handleAdd(@ModelAttribute Users user) {
		userService.save(user);
		return "redirect:/";
	}
	
	
}