package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.creator.TemplateCreator;

import lombok.RequiredArgsConstructor;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {

	private final TemplateCreator creator;
	
	@GetMapping("/rest")
	public String call() {
		return creator.create();
	}
	
}
