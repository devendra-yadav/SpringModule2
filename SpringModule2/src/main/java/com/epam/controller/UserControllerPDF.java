package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.model.User;
import com.epam.service.UserService;

@Controller
@RequestMapping("/user/pdf")
public class UserControllerPDF {
	@Autowired
	private UserService theUserService;
	
	@GetMapping("/list-all")
	public String listAllUsers(Model model) {
		List<User> allUsers=theUserService.getAll();
		model.addAttribute("allUsers", allUsers);
		
		return "pdfViewAllUsers";
	}
}
