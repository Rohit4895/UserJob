package com.example.jobapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jobapi.model.JobSkillWrapper;
import com.example.jobapi.model.Jobs;
import com.example.jobapi.model.Skills;
import com.example.jobapi.model.User;
import com.example.jobapi.repository.JobsRepository;
import com.example.jobapi.repository.RoleRepository;
import com.example.jobapi.repository.SkillsRepository;
import com.example.jobapi.repository.UserRepository;
import com.example.jobapi.model.Role;
import com.example.jobapi.config.UserPrincipal;

@Service(value = "userService")
@Transactional
public class UserServiceImplementation implements UserService , UserDetailsService{
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private JobsRepository jobRepo;
	
	@Autowired
	private SkillsRepository skillRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public List<Jobs> getAllJob() {
		return jobRepo.findAll();
	}

	@Override
	public List<Skills> getAllSkills() {
		return skillRepo.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userRepo.findById(id).orElse(null);
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepo.getUserByEmail(email);
		
	}

	@Override
	public Jobs getJobById(long id) {
		Jobs jobs = jobRepo.findById(id).orElse(null);
		return jobs;
	}

	@Override
	public Jobs getJobByCompany(String companyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jobs getJobsForSkill(long skillId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skills getSkillsForJob(long jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserUser(User user) {
		
		  User inUser = new User(); inUser.setId(user.getId());
		  String pass = bcryptEncoder.encode(user.getPassword());
		  inUser.setUserName(user.getUserName());
		  inUser.setFirstName(user.getFirstName());
		  inUser.setLastName(user.getLastName());
		  inUser.setPassword(pass);
		  inUser.setEmail(user.getEmail());
		  
		  System.out.println("Pass: "+ inUser.getPassword());
		  
		 inUser.setRoles(user.getRoles());
		
		userRepo.save(inUser);
	}

	@Override
	public void insertSkillsAndJobs(JobSkillWrapper jobSkillWrapper) {
		Jobs jobs = jobSkillWrapper.getJobs();
		List<Skills> skillList = jobSkillWrapper.getSkills();
		
		Jobs inJobs = new Jobs();
		inJobs.setId(jobs.getId());
		inJobs.setCompanyName(jobs.getCompanyName());
		inJobs.setCity(jobs.getCity());
		inJobs.setSalary(jobs.getSalary());
		inJobs.setJobTitle(jobs.getJobTitle());	
		
		inJobs.setskillList(skillList);
		
		jobRepo.save(inJobs);
		
	}

	@Override
	public void inserSkills(Skills skills) {
		
		Skills inSkill = new Skills();
		inSkill.setId(skills.getId());
		inSkill.setSkillName(skills.getSkillName());
		
		skillRepo.save(inSkill);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("usernaeee::::::::::::::"+username);
		User user = userRepo.findUserByUserName(username);
		System.out.println("username::::::::::::::"+user);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		//return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
		return  UserPrincipal.create(user);
	}
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}
