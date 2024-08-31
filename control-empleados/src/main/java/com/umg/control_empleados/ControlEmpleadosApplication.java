package com.umg.control_empleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ControlEmpleadosApplication extends SpringBootServletInitializer {

	public static void main (String[] args) {
		SpringApplication.run(ControlEmpleadosApplication.class, args);
	}


	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ControlEmpleadosApplication.class);
	}

}
