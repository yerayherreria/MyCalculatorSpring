package com.jacaranda.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jacaranda.calculator.model.Calculator;

@Controller
public class ControllerCalculator {
	
	@GetMapping("/calculadora")
	public String calculator(Model model) {
		Calculator calculator = new Calculator();
		model.addAttribute("calc",calculator);
		
		
		return "calculadora";
	}
	
	@GetMapping("/resolver")
	public String resolver(Model model, @ModelAttribute("calc") Calculator c) throws Exception {
		Calculator calculator = new Calculator();
		model.addAttribute("calc",calculator);
		String result = "Previus operation: "+c.getNumber1()+c.getOpe()+c.getNumber2()+"="+c.getResult();
		
		model.addAttribute("result", result);
		return "calculadora";
		
	}
}
