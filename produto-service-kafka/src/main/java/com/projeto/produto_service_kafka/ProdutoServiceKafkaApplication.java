package com.projeto.produto_service_kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class ProdutoServiceKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoServiceKafkaApplication.class, args);
	}

}
