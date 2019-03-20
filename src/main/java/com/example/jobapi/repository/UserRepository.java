package com.example.jobapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jobapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User getUserByEmail(String emailId);
	User findUserByUserName(String userName);
}
