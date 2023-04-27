package com.example.crud1.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepositry extends JpaRepository<StudentModel, Integer>{


	@Query
	StudentModel findByEmail(String email);
}
