package com.application.dispatch.api.rest.login;

import com.application.dispatch.entity.User;
import com.application.dispatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/api/profile")
	public ResponseEntity getUserProfile() {
		Map<String, Object> response = new HashMap<>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		user.setPassword(null);
		response.put("user", user);
		response.put("result", "Success");
		return new ResponseEntity(response, HttpStatus.OK);
	}

	@PostMapping("/api/register")
	public ResponseEntity registerUser(@RequestBody User userDto) {
		Map<String, Object> response = new HashMap<>();
		userService.registerUser(userDto);
		response.put("result", "Success");
		response.put("message", "User registered successfully");
		return new ResponseEntity(response, HttpStatus.OK);
	}
}
