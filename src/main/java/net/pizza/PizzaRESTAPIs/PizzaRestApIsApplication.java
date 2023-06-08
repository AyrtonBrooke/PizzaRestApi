package net.pizza.PizzaRESTAPIs;

import net.pizza.PizzaRESTAPIs.auth.AuthService;
import net.pizza.PizzaRESTAPIs.auth.RegisterRequest;
import net.pizza.PizzaRESTAPIs.admin.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static net.pizza.PizzaRESTAPIs.admin.Role.ADMIN;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzaRestApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaRestApIsApplication.class, args);
	}
}
