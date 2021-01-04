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
import java.util.Map;

//http://localhost:8080/test/hm
@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	CounterRepo repo;

	@GetMapping(value = "/hm")
	public String getTestData() {
		Map<String, String> env = System.getenv();
		try {
			List<Counter> counters = (List<Counter>) repo.findAll();
			Counter c = counters.get(0);
			Long number = c.getCounter();
			number = number + 1;
			c.setCounter(number);
			repo.save(c);

			return new String(number.toString()+" "+env.get("APP_NAME"));
		} catch (Exception e) {
			repo.save(new Counter((long) 0));
			return ("1"+" "+env.get("APP_NAME"));
		}
	}
}