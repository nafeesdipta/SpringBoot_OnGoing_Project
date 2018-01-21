package com.sweet.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import org.springframework.web.bind.annotation.GetMapping;

import com.sweet.springboot.service.TaskService;

@Controller
public class MainController {

	@GetMapping("/")
	public String hello(){
		return "index";
	}
}
