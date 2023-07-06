package com.example.demo.creator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.example.demo.vo.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TemplateCreatorImpl implements TemplateCreator {

	@Qualifier("rest")
	private final SpringTemplateEngine templateEngine;
	
	@Override
	public String create() {
		var context = new Context();
		context.setVariable("bean", new User(20, "Piyo Piyo"));
		return templateEngine.process("rest", context);
	}

}
