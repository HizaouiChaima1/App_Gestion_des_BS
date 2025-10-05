package com.tunisia.telecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.tunisia.telecom.security.CorsProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableConfigurationProperties(CorsProperties.class)
public class BackendfinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendfinalApplication.class, args);
	}

}
