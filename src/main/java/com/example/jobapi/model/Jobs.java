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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "jobs")
public class Jobs implements Serializable{
	@Id
	@Column(name = "id")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "jobTitle")
	private String jobTitle;
	
	@Column(name = "companyName")
	private String companyName;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "salary")
	private long salary;
	
	 @ManyToMany(cascade=CascadeType.ALL)
		    @JoinTable(name = "job_skill",
		        joinColumns = {@JoinColumn(name = "jobId")},
		        inverseJoinColumns = {@JoinColumn(name = "skillId")}
		    )
	 //@JsonManagedReference
     private List<Skills> skillList;

	public Jobs() {
		super();
	}
	
	public Jobs(String jobTitle, String companyName, String city, long salary) {
		super();
		this.jobTitle = jobTitle;
		this.companyName = companyName;
		this.city = city;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public List<Skills> getskillList() {
		return skillList;
	}

	public void setskillList(List<Skills> skillList) {
		this.skillList = skillList;
	}

}
