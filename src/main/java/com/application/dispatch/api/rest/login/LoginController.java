package com.application.dispatch.api.rest.login;

import com.application.dispatch.entity.User;
import com.application.dispatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(produces = "application/json")
    @RequestMapping({ "/api/validateLogin" })
    public ResponseEntity validateLogin() {
        Map<String, Object> response = new HashMap<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        user.setPassword(null);
        response.put("user", user);
        response.put("result", "Success");
        response.put("message", "Login successfully");
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
