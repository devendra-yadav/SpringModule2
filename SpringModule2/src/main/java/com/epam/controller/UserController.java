package com.epam.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.epam.model.User;
import com.epam.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService theUserService;
	
	@GetMapping("/create-form")
	public String createUserForm(Model model) {
		model.addAttribute("user", new User());
		return "create-user-form";
	}
	
	@PostMapping("/create")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResults, Model model) {
		System.out.println(user);
		
		Map<String, String> output=new HashMap<>();
		if(bindingResults.hasErrors()) {
			System.out.println("Binding results : "+bindingResults);
			model.addAttribute("user", user);
			output.put("error", "Some issue in saving User");
		}else {
			theUserService.create(user);
			output.put("success", "Successfully saved user. UserID created for '"+user.getName()+"' : "+user.getId());
			model.addAttribute("user", new User());
			
		}
		
		model.addAttribute("output", output);
		
		return "createUserForm";
	}
	
	@GetMapping("/list-all")
	public String listAllUsers(Model model) {
		List<User> allUsers=theUserService.getAll();
		model.addAttribute("allUsers", allUsers);
		
		return "list-all-users";
	}
	
	@GetMapping("/search-form")
	public String showSearchUsersPage() {
		return "search-user-form";
	}
	
	@PostMapping("/search-by-id")
	public String searchUserById(@RequestParam("id") int id, Model model) {
		
		User theUser=theUserService.getUserById(id);
		
		model.addAttribute("user", theUser);
		
		
		return "search-user-result-name";
	}
	
	@PostMapping("/search-by-name")
	public String searchUserByName(@RequestParam("name") String name, Model model) {
		
		User theUser=theUserService.getUserByName(name);
		
		model.addAttribute("user", theUser);
				
		return "search-user-result-name";
	}
	
	@PostMapping("/search-by-email")
	public String searchUserByEmail(@RequestParam("email") String email, Model model) {
		
		
		User theUser=theUserService.getUserByEmail(email);
		
		model.addAttribute("user", theUser);
		
		return "search-user-result-email";
	}
	
	@GetMapping("/create-users-from-file-form")
	public String createUsersFromFileForm() {
		
		return "create-users-from-file-form";
	}
	
	@PostMapping("create-users-from-file")
	public String createUsersFromFile(@RequestParam("name") MultipartFile file, Model model) throws JsonParseException, JsonMappingException, IOException {
		
		System.out.println("file uploaded : "+file.getOriginalFilename());
		ObjectMapper mapper=new ObjectMapper();
		mapper.findAndRegisterModules();
		
		List<User> users=mapper.readValue(file.getInputStream(), new TypeReference<List<User>>() {});
		
		theUserService.createUsers(users);
		
		Map<String, String> output=new HashMap<>();
		output.put("success", "Successfully created all users present in '"+file.getOriginalFilename()+"' file.");
		
		model.addAttribute("output", output);
		
		return "create-users-from-file-form";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor trimmer=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trimmer);
	}
	
}