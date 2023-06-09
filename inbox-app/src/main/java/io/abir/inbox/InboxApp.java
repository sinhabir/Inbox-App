package io.abir.inbox;

import java.nio.file.Path;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class InboxApp {
	
	public static void main(String[] args) {
		SpringApplication.run(InboxApp.class, args);
	}
	
 @Bean
 public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraproperties) {
	 Path bundle = astraproperties.getSecureConnectBundle().toPath();
	 return builder -> builder.withCloudSecureConnectBundle(bundle);
	 
 }
	
	
}
