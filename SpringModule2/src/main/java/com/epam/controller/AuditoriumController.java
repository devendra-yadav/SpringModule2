package com.epam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.epam.model.Auditorium;
import com.epam.service.AuditoriumService;

@Controller
@RequestMapping("/auditorium")
public class AuditoriumController {

	@Autowired
	private AuditoriumService theAuditoriumService;
	
	@RequestMapping("/create-form")
	public String createAuditoriumForm(Model model) {
		model.addAttribute("auditorium", new Auditorium());
		return "create-auditorium-form";
	}
	
	@PostMapping("/create")
	public String createAuditorium(@Valid @ModelAttribute("auditorium") Auditorium auditorium, BindingResult bindingResult, Model model) {
		System.out.println("Auditorium : "+auditorium);
		
		Map<String, String> output=new HashMap<>();
		if(bindingResult.hasErrors()) {
			model.addAttribute("auditorium", auditorium);
			output.put("error", "Some issues in creating Auditorium.");
			model.addAttribute("output", output);
			return "create-auditorium-form";
		}
		
		int auditoriumId=theAuditoriumService.create(auditorium);
		output.put("success", "Auditorium '' created. Auditorium ID generated : "+auditoriumId);
		model.addAttribute("output", output);
		model.addAttribute("auditorium", new Auditorium());
		
		return "create-auditorium-form";
	}
	
	@GetMapping("/list-all")
	public String listAllAuditoriums(Model model) {
		List<Auditorium> allAuditoriums=theAuditoriumService.getAll();
		model.addAttribute("allAuditoriums", allAuditoriums);
		
		return "list-all-auditoriums";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor trimmer=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trimmer);
	}
}
