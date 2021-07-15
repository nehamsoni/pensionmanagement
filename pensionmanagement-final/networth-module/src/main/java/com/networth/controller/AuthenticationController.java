package com.networth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.networth.config.JwtTokenUtil;
import com.networth.model.ApiResponse;
import com.networth.model.AuthToken;
import com.networth.model.LoginUser;
import com.networth.model.User;
import com.networth.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;
    
    
    private  AuthToken auth =null;
    
    
    @PostMapping(value = "/generate-token")
    public AuthToken register(@RequestBody LoginUser loginUser) throws AuthenticationException {
    	
    	System.out.print(loginUser);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final User user = userService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        auth = new AuthToken(token, user.getUsername());
        
        return auth;
    }
    
    @GetMapping(value = "/get-token")
    public String get(){
    	return "Bearer "+auth.getToken();
    }

}