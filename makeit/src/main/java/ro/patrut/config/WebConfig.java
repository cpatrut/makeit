package ro.patrut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@PropertySource(value = { "classpath:/static/properties/jdbc.properties" })
@ComponentScan(basePackages = "ro.patrut.controllers")
@Import({ SecurityConfiguration.class, HibernateConfig.class })
@ImportResource(value = { "classpath:/ro/patrut/services/dao/makeit-dao.xml",
		"classpath:/ro/patrut/services/makeit-service.xml" })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver getInternalResoureViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/angular/**").addResourceLocations("/webresources/node_modules/angular/");
		registry.addResourceHandler("/bootstrap/**").addResourceLocations("/webresources/node_modules/bootstrap/");
		registry.addResourceHandler("/css/**").addResourceLocations("/webresources/css/");

	}
}
