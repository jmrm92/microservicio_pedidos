package com.master.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidosApplication.class, args);
	}

	/**
	* Configura y crea un bean de RestTemplate.
	* 
	* @return Una instancia de RestTemplate.
	*/
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
