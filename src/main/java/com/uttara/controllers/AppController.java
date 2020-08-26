package com.uttara.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppController {

	@GetMapping(value = {"","/"})
	public String welcome() {
		
		return "Hi welcome to Todo app";
	}
	
}
