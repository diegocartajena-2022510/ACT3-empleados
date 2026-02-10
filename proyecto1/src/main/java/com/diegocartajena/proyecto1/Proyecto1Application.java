package com.diegocartajena.proyecto1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Proyecto1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Proyecto1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("api funcionando");
	}
}
