package com.example.jobapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.jobapi.model.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Long>{

	@Query("SELECT DISTINCT s FROM Skills s INNER JOIN s.jobList j where j.id=:jobId")
	List<Skills> getSkillsForJobs(int jobId);
}
