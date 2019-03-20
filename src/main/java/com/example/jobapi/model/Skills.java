package com.example.jobapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "skills")
public class Skills implements Serializable {
	
	@Id
	@Column(name = "id")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "skillName")
	private String skillName;
	
	@ManyToMany(cascade= CascadeType.ALL,mappedBy = "skillList")
	//@JsonBackReference
	@JsonIgnore
    private List<Jobs> jobList;

	public Skills() {
		super();
	}
	
	public Skills(String skillName) {
		super();
		this.skillName = skillName;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public List<Jobs> getJobList() {
		return jobList;
	}

	public void setJobList(List<Jobs> jobList) {
		this.jobList = jobList;
	}
}
