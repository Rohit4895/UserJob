package com.example.jobapi.model;

import java.util.List;

public class JobSkillWrapper {
	
	private Jobs jobs;
	private List<Skills> skills;
	
	public JobSkillWrapper(Jobs jobs, List<Skills> skills) {
		super();
		this.jobs = jobs;
		this.skills = skills;
	}
	public Jobs getJobs() {
		return jobs;
	}
	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}
	public List<Skills> getSkills() {
		return skills;
	}
	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}
	
	
}
