package com.example.captstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.capstone.model.Workers;

@Repository
public interface WorkerRepository extends JpaRepository< Workers,Long>{
		
	
}
