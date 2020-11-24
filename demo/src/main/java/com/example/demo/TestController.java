package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repo.CounterRepo;
import com.example.demo.data.Counter;
import java.util.List;

//http://localhost:8080/test/hm --> putanja, samo stigne json za sad
@RestController
@RequestMapping(value = "/test")
public class TestController {
	
	@Autowired
	CounterRepo repo;
 
	 @GetMapping(value = "/hm")
    public String getTestData() {
		List<Counter> counters = (List<Counter>) repo.findAll();
		Counter c = counters.get(0);
		Long number = c.getCounter();
		number=number+1;
		c.setCounter(number);
		repo.save(c);
		
        return new String(number.toString());
    }
}