package com.application.dispatch.api.rest.admin;

import com.application.dispatch.entity.User;
import com.application.dispatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/user")
@RestController
public class AdminController {
	@Autowired
	UserService userService;

	@GetMapping("/{userId}")
	public ResponseEntity getUserByEmail(@PathVariable String email) {
		Map<String, Object> response = new HashMap<>();
		response.put("user", userService.findUserByEmail(email));
		response.put("status", "SUCCESS");
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity getAllUsers() {
		Map<String, Object> response = new HashMap<>();
		response.put("users", userService.getAllUsers());
		response.put("status", "SUCCESS");
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity saveUser(@RequestBody User userDto) {
		Map<String, Object> response = new HashMap<>();
		userService.saveUser(userDto);
		response.put("status", "SUCCESS");
		response.put("message", "User created successfully");
		return new ResponseEntity(response, HttpStatus.OK);

	}
}
