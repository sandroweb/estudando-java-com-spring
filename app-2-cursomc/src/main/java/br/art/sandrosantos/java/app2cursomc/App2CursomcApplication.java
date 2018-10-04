package br.art.sandrosantos.java.app2cursomc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class App2CursomcApplication {

	public static void main(String[] args) {
		SpringApplication.run(App2CursomcApplication.class, args);
	}
}
