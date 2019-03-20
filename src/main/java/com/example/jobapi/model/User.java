package com.example.jobapi.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;
import java.util.Set;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.jobapi.model.Role;

@Entity(name = "user")
public class User implements Serializable {
	
	@Id
	@Column(name = "id", unique = true)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "userName", unique = true, nullable = false)
	private String userName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id" )
	private List<Role> roles;

	public User() {
	}
	
	public User(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", email=" + email + ", password=" + password + ", roles=" + roles + "]";
	}

	
}
