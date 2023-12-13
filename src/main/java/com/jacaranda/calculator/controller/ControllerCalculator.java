package com.jacaranda.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.calculator.model.Calculator;
import com.jacaranda.calculator.model.ElectricalPower;

import jakarta.servlet.http.HttpServletRequest;

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
	
	@GetMapping("/electricalPower")
	public String electricalPower(Model model) {
		ElectricalPower ep = new ElectricalPower();
		model.addAttribute("elp",ep);
		
		return "electricalPower";
	}
	
	@GetMapping("/resol")
	public String resol(@Validated Model model,@ModelAttribute("elp") ElectricalPower ep,BindingResult br) throws Exception {
		ElectricalPower ep2 = new ElectricalPower();
		model.addAttribute("elp",ep2);
		
		if(br.hasErrors()) {
			model.addAttribute("result", "No se puede resolver");
			return "electricalPower";
		}
		String result = "Electrical Power: "+ep.getVolt()+"*"+ep.getAmp()+"="+ep.getResult()+"W";
		
		model.addAttribute("result", result);
		return "electricalPower";
		
	}
	/*
	@GetMapping("/error")
	public String error(Model model, @RequestParam("msg") String msg) {
		model.addAttribute("msg", msg);
		return "error";
	}

	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, HttpServletRequest request) {
	    // Handle it
	    return "error?msg="+ e.getMessage();
	}*/
}
