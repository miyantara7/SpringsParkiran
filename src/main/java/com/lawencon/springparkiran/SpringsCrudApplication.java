package com.lawencon.springparkiran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories("com.lawencon.....) buat jika model beda package
//@ComponentScan untuk jika controller beda package
public class SpringsCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsCrudApplication.class, args);
	}

}
