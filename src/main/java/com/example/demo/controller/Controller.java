package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.vo.User;

import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {

	@GetMapping("/normal")
	public ModelAndView call() {
		return new ModelAndView("normal").addObject("bean", new User(10, "Hoge Hoge"));
	}
	
}
