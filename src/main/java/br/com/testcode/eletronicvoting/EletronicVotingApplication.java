package br.com.testcode.eletronicvoting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableFeignClients
@EnableJpaAuditing
@SpringBootApplication
public class EletronicVotingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EletronicVotingApplication.class, args);
	}

}
