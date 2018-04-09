package com.seekerscapital.sp.mainclass;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seekerscapital.sp.util.LoggerUtil;
import com.seekerscapital.sp.util.LoggingUtil;
/**
 * @author Ramesh

/**
 * Application 
 * 
 * @author Ramesh
 */
@SpringBootApplication
public class Application {
	private static Logger log = LoggerUtil.getServiceLogger();
	public static void main(String[] args) {
		
		log.info("Spring Boot Application Started");
		LoggingUtil.logEnteringMethod("Application", "main", log);
		SpringApplication.run(Application.class, args);
	}

}
