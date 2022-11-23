package com.project.api.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class LocaleConfig {
	@Bean
	public LocaleResolver localeResolver() {
	    AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
	    localeResolver.setDefaultLocale(Locale.US);
	    Locale.setDefault(Locale.US);
	    return localeResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasenames("i18n/messages");
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}
}
