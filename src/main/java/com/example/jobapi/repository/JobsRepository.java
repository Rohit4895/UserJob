package com.example.jobapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jobapi.model.Jobs;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Long> {

}
