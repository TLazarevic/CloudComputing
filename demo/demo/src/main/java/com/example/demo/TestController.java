package com.example.demo;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8080/test/hm --> putanja, samo stigne json za sad
@RestController
@RequestMapping(value = "/test")
public class TestController {
 
	 @GetMapping(value = "/hm", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTestData() {
        return new ResponseEntity<String>("Working", HttpStatus.OK);
    }
}