
package au.com.riosoftware.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class ServerApplication {

	   public static void main(String[] args) {
	        SpringApplication.run(ServerApplication.class, args);
	    }
}