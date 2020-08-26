package com.telusko.springmvcboot;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.springmvcboot.model.Alien;

@Controller
public class HomeController {
	
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name", "Anuveer");
	}
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("add")
	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m) {
		int num3 = i+j;
		m.addAttribute("num3", num3);
		return "result";
	}
	
	@PostMapping("addAlien")
	public String addAlien(Alien a) {
		return "result";
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m) {
		List<Alien> aliens = Stream.of(new Alien(10, "Anu"), new Alien(26, "Ankit")).collect(Collectors.toList());
		m.addAttribute("aliens", aliens);
		return "showAliens";
	}
}
