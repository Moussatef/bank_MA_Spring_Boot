package com.bank.bankAM;

import com.google.common.reflect.TypeResolver;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication
public class BankAmApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAmApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder(){
		return  new BCryptPasswordEncoder();
	}


}
