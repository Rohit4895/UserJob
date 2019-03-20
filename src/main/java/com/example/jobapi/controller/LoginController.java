package com.example.jobapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobapi.model.User;
import com.example.jobapi.repository.UserRepository;
import com.example.jobapi.service.UserService;
import com.example.jobapi.utils.ApiResponse;
import com.example.jobapi.utils.AuthToken;
import com.example.jobapi.utils.LoginUser;
import com.example.jobapi.config.JwtTokenUtil;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepo;
	
	/*
	 * @PostMapping(value = "/user", headers="Accept=application/json")
	 * public @ResponseBody ResponseEntity<Void> validateUser(@RequestBody User
	 * user){
	 * 
	 * User verifyUser = userService.getUserByEmail(user.getEmail()); String email =
	 * verifyUser.getEmail(); String password = verifyUser.getPassword();
	 * 
	 * if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
	 * return new ResponseEntity<Void>(HttpStatus.ACCEPTED); }
	 * 
	 * return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST); }
	 */
	
	@PostMapping(value = "/user", headers="Accept=application/json")
	 public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

    	 Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword()));
       
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generate(authentication);
        
        final User user = userRepo.findUserByUserName(loginUser.getUserName());
        System.out.println("Controller : "+user);
        
       // final String token = jwtTokenUtil.generateToken(user);
        return new ApiResponse<>(200, "success",new AuthToken(jwt, user.getUserName()));
    }

	
}
