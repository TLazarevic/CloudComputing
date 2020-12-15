package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.Counter;

@Repository
public interface CounterRepo extends JpaRepository<Counter, Long> {
	
	public List<Counter> findAll();
	

}
