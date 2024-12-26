package com.gearing.burgertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.gearing.burgertracker.models.Burger;
import com.gearing.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	@Autowired
	private BurgerService burgerService;
	
	@GetMapping("/burgers")
	public String index(Model model, @ModelAttribute Burger burger) {
		List<Burger> burgers = burgerService.allBurgers();
		
		model.addAttribute("burgers", burgers);
		
		return "index.jsp";
	}
	
	@PostMapping("/burgers")
	public String create(Model model, @Valid @ModelAttribute Burger burger, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("burgers", burgerService.allBurgers());
			return "index.jsp";
		}
		burgerService.createBurger(burger);
		return "redirect:/burgers";
	}
	
	@GetMapping("/burgers/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		Burger burger = burgerService.findBurger(id);
		model.addAttribute("burger", burger);
		return "update.jsp";
	}
	
	@PutMapping("/burgers/{id}")
	public String update(@Valid @ModelAttribute Burger burger, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("burger", burger);
			return "update.jsp";
		}
		
		burgerService.updateBurger(burger);
		return "redirect:/burgers";
	}
	
}
