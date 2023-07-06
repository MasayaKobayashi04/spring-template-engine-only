package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class SpringTemplateEngineConfig {
	
	private static final ClassLoaderTemplateResolver classLoaderTemplateResolver(String prefix) {
		ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
		resolver.setTemplateMode(TemplateMode.HTML);
		resolver.setPrefix(prefix);
		resolver.setSuffix(".html");
		resolver.setCharacterEncoding("UTF-8");
		resolver.setCacheable(true);
		return resolver;
	}
	
	private static final SpringTemplateEngine springTemplateEngineFactory(String prefix) {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(classLoaderTemplateResolver(prefix));
		return engine;
	}
	
	@Bean
	@Primary
	public SpringTemplateEngine primarySpringTemplateEngine() {
		return springTemplateEngineFactory("normal-templates/");
	}
	
	@Bean("rest")
	public SpringTemplateEngine pdfSpringTemplateEngine() {
		return springTemplateEngineFactory("rest-templates/");
	}
	
}
