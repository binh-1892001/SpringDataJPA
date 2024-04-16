package com.ra.controller;

import com.ra.model.Users;
import com.ra.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	// truyền tham số //https://localhost:8080/users?page=0&size=5&sort=id&order=ASC
	@GetMapping("")
	public String index(
//			  @RequestParam(value = "page",defaultValue = "0") Integer page,
//			  @RequestParam(value = "size",defaultValue = "5") Integer size,
//			  @RequestParam(value = "sort",defaultValue = "id") String sort,
//			  @RequestParam(value = "order",defaultValue = "ASC") String order,
			  @PageableDefault(page = 0,size = 5,sort = "id",direction = Sort.Direction.ASC) Pageable pageable,
			  Model model
			  ) {
		
		// nếu dùng pageableDefault thì page => page
		// size => size
		// sort => sort|ASC
		// order =>
//		Pageable pageable;
//		if(order.equals("ASC")) {
//			pageable = PageRequest.of(page,size, Sort.by(sort).ascending());
//		} else {
//			pageable = PageRequest.of(page,size, Sort.by(sort).descending());
//		}
		
		/**
		 * {
		 *    content: []
		 *    pageable: {
		 *    	pageNumber: 0,
		 *    	pageSize: 5
		 *    }
		 * }
		 * */
		Page<Users> users = userService.findAll(pageable);
		model.addAttribute("users",users);
		model.addAttribute("totalPages",users.getTotalPages());
//		model.addAttribute("pagination",)
		return "index";
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