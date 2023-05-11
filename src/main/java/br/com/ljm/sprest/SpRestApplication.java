package br.com.ljm.sprest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.ljm.sprest.entities"})
@EnableKafka
public class SpRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpRestApplication.class, args);
	}
}
