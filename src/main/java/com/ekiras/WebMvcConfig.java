package com.ekiras;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;
import java.util.Locale;

@Configuration
@ComponentScan(basePackages = { "com.ekiras" })
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	private int maxUploadSizeInMb = 3 * 1024 * 1024; // 3 MB

	@Value("${com.spring.path}")
	private String path;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/accessDenied").setViewName("accessDenied");
		registry.addViewController("/login").setViewName("login");
	}


	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/*@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver b = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();		
		mappings.put("ExceptionControllerAdvice", "error");
		mappings.put("java.lang.Exception", "error");
		b.setExceptionMappings(mappings);
		return b;
	}*/

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();

		// Set the maximum allowed size (in bytes) for each individual file.
		resolver.setMaxUploadSize(5242880);// 5MB

		// You may also set other available properties.

		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/bootstrap/**").addResourceLocations("classpath:/static/bootstrap/3.1.0/");
		registry.addResourceHandler("/jquery/**").addResourceLocations("classpath:/static/jquery/");
		registry.addResourceHandler("/jqueryui/**").addResourceLocations("classpath:/static/jqueryui/");
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
		registry.addResourceHandler("/font-awesome/**").addResourceLocations("classpath:/static/font-awesome/");
		registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
		registry.addResourceHandler("/demo/**").addResourceLocations("classpath:/static/img/demo/");
		registry.addResourceHandler("/gallery/**").addResourceLocations("classpath:/static/img/gallery/");
		registry.addResourceHandler("/font-awesome/**").addResourceLocations("classpath:/static/font-awesome/");
		registry.addResourceHandler("/datepicker/**").addResourceLocations("classpath:/static/datepicker/");
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("/pages/**").addResourceLocations("classpath:/static/pages/");
		registry.addResourceHandler("/less/**").addResourceLocations("classpath:/static/less/");
		registry.addResourceHandler("/plugins/**").addResourceLocations("classpath:/static/plugins/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/static/fonts/");
		registry.addResourceHandler("/webfonts/**").addResourceLocations("classpath:/static/webfonts/");

		/* linux */
		// registry.addResourceHandler("/foto/**").addResourceLocations("file:///home/saifi/Desktop/foto/");
		/* windows */
		registry.addResourceHandler("/tutorial_pdf/**").addResourceLocations("file://" + path);
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

	}


	/*
	 * @Bean public CommonsMultipartResolver multipartResolver(){
	 * CommonsMultipartResolver multipartResolver = new
	 * CommonsMultipartResolver();
	 * multipartResolver.setMaxUploadSize(maxUploadSizeInMb); return
	 * multipartResolver; }
	 */

	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
		return multipartResolver;
	}

	/*
	 * @Override public void
	 * addArgumentResolvers(List<HandlerMethodArgumentResolver>
	 * argumentResolvers) { PageableHandlerMethodArgumentResolver resolver = new
	 * PageableHandlerMethodArgumentResolver(); resolver.setFallbackPageable(new
	 * PageRequest(1, 5) ); argumentResolvers.add(new
	 * ServletWebArgumentResolverAdapter((WebArgumentResolver) resolver)); }
	 */

	/*
	 * @Override public void
	 * addArgumentResolvers(List<HandlerMethodArgumentResolver>
	 * argumentResolvers) { PageableArgumentResolver resolver = new
	 * PageableArgumentResolver(); resolver.setFallbackPagable(new
	 * PageRequest(1, 5)); argumentResolvers.add(new
	 * ServletWebArgumentResolverAdapter(resolver)); }
	 */


	@Bean(name = "messageSource")
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		// messageSource.setBasename("/i18n/smsmsg");
		messageSource.setBasename("classpath:i18n/sms_msg");
		messageSource.setDefaultEncoding("UTF-8");
		/*
		 * ResourceBundleMessageSource result = new
		 * ResourceBundleMessageSource();
		 * 
		 * String[] basenames = { "classpath:/i18n.sms_msg", "classpath:messages"
		 * }; result.setDefaultEncoding("UTF-8");
		 * result.setBasenames(basenames);
		 */
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));
		resolver.setCookieName("myLocaleCookie");
		resolver.setCookieMaxAge(4800);
		return resolver;
	}


	
	/*@Bean
	public TemplateResolver templateResolver(){
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setTemplateMode("HTML5");
		return templateResolver;
	}
	
	@Bean
	public SpringTemplateEngine templateEngine(){
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setAdditionalDialects(securityDialect());
		templateEngine.setTemplateResolver(templateResolver());
		return templateEngine;
	}
		
	@Bean
	public Set<IDialect> securityDialect(){	
		IDialect dialect = new SpringSecurityDialect();
		Set<IDialect> dialects = new HashSet();
		dialects.add(dialect);
		return dialects;
	}*/
	
}
