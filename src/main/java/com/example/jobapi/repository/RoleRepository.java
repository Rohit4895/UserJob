package com.example.jobapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobapi.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByname(String name);
}
