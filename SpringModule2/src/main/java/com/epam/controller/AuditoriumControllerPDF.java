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
@RequestMapping("/auditorium/pdf")
public class AuditoriumControllerPDF {

	@Autowired
	private AuditoriumService theAuditoriumService;
	
	@GetMapping("/list-all")
	public String listAllAuditoriums(Model model) {
		List<Auditorium> allAuditoriums=theAuditoriumService.getAll();
		model.addAttribute("allAuditoriums", allAuditoriums);
		
		return "pdfViewAllAuditoriums";
	}
	
}
