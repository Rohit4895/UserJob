package com.example.jobapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jobapi.model.JobSkillWrapper;
import com.example.jobapi.model.Jobs;
import com.example.jobapi.model.Skills;
import com.example.jobapi.model.User;

public interface UserService {
	public List<User> getAllUser();
	public List<Jobs> getAllJob();
	public List<Skills> getAllSkills();
	public void inserUser(User user);
	public User getUserById(long id);
	public User getUserByEmail(String email);
	public Jobs getJobById(long id);
	public Jobs getJobByCompany(String companyName);
	public Jobs getJobsForSkill(long skillId);
	public Skills getSkillsForJob(long jobId);
	public void inserSkills(Skills skills);
	public void insertSkillsAndJobs(JobSkillWrapper jobSkillWrapper);
}
