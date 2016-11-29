package com.roncoo.jui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 
 * @author wujing
 */
@ServletComponentScan
@SpringBootApplication
public class RoncooJuiSpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoncooJuiSpringbootWebApplication.class, args);
	}

}
