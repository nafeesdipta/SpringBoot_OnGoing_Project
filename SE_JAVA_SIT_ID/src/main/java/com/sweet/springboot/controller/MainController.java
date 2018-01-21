package com.sweet.springboot.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sweet.springboot.model.Task;
import com.sweet.springboot.service.TaskService;

@Controller
public class MainController {
	
	@Autowired
	private TaskService taskService;
	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("tasks", taskService.findAll() );
		return "index";
	}
	
	@GetMapping("/showproducts")
	public String allTasks(HttpServletRequest request){
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	@GetMapping("/newproduct")
	public String newTask(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@PostMapping("/saveproduct")
	public String saveTask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request){
		taskService.save(task);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	@GetMapping("/updateproduct")
	public String updateTask(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("task", taskService.findTask(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/deleteproduct")
	public String deleteTask(@RequestParam int id, HttpServletRequest request){
		taskService.delete(id);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
}
