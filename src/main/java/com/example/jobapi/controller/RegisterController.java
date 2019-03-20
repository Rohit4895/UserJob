package com.example.jobapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.jobapi.model.JobSkillWrapper;
import com.example.jobapi.model.Jobs;
import com.example.jobapi.model.Skills;
import com.example.jobapi.model.User;
import com.example.jobapi.service.UserService;
import java.util.Base64;

@RestController
@RequestMapping(value = "/register")
public class RegisterController {
	@Autowired
	private UserService userService;

	  @PreAuthorize("hasRole('ROLE_RECRUITER') or hasRole('ROLE_ADMIN')")
	  @PostMapping(value = "/jobs", consumes = MediaType.APPLICATION_JSON_VALUE) 
	  public ResponseEntity<Void> createJobs(@RequestBody JobSkillWrapper jobSkillWrapper){
		  userService.insertSkillsAndJobs(jobSkillWrapper);
	  return new ResponseEntity<Void>(HttpStatus.CREATED); 
	  }
	  

	  @PostMapping(value = "/users", headers="Accept=application/json")
		public ResponseEntity<Void> createUsers(@RequestBody User user){
			 userService.inserUser(user); 
	       return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	  
	 
	  @PostMapping(value = "/skills", headers="Accept=application/json")
	  public ResponseEntity<Void> createSkills(@RequestBody Skills skills){
		  userService.inserSkills(skills);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		  
	  }

}
