package com.mreclamation;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.mreclamation.entities.Avis;
import com.mreclamation.entities.Reclamation;
import com.mreclamation.repositories.AvisRepository;
import com.mreclamation.repositories.ReclamationRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceReclamationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceReclamationApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner startAvis(AvisRepository avisRepository) {
//		return (args) -> {
//			Stream.of(new Avis("Ambiance", "Tres bonne ambiance"), new Avis("Hygiene", "Tres bonne hygiene"),
//					 new Avis("Prestation", "j'adore ma couleur")).forEach((v) -> {
//						 avisRepository.save(v);
//			});
//		};
//	}
//
//	@Bean
//	CommandLineRunner startReclamation(ReclamationRepository reclamationRepository) {
//		return (args) -> {
//			Stream.of(new Reclamation("Ambiance", "Tres bonne ambiance"), new Reclamation("Hygiene", "Tres bonne hygiene"),
//					 new Reclamation("Prestation", "j'adore ma couleur")).forEach((v) -> {
//						 reclamationRepository.save(v);
//			});
//		};
//	}
}
