package com.example.jobapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobapi.model.JobSkillWrapper;
import com.example.jobapi.model.Jobs;
import com.example.jobapi.model.Skills;
import com.example.jobapi.model.User;
import com.example.jobapi.service.UserService;

@RestController
@RequestMapping("/get")
public class DataController {
	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping(value="/job/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Jobs> getJobById(@PathVariable long id) {
		Jobs job = userService.getJobById(id);
		 if (job == null) {
	            return new ResponseEntity<Jobs>(HttpStatus.NOT_FOUND);
	        }
        return new ResponseEntity<Jobs>(job,HttpStatus.OK);

    }
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping(value = "/jobList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Jobs>> getAllJobs() {
        System.out.println("Fetching Job with id ");
        List<Jobs> jobs = userService.getAllJob();
        System.out.println("List Size: "+ jobs.size());
        if (jobs == null) {
            return new ResponseEntity<List<Jobs>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Jobs>>(jobs, HttpStatus.OK);
    }
	
	@GetMapping(value = "/skillList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Skills>> getAllSkills() {
        System.out.println("Fetching Job with id ");
        List<Skills> skills = userService.getAllSkills();
        System.out.println("List Size: "+ skills.size());
        if (skills == null) {
            return new ResponseEntity<List<Skills>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Skills>>(skills, HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value ="/userList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUserList(){
		List<User> users = userService.getAllUser();
		if(users == null) {
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}


}
