package org.sid.bourseservice;

import org.sid.bourseservice.dao.SocieteRepository;
import org.sid.bourseservice.entities.Societe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;


import java.util.stream.Stream;

@EnableEurekaClient
@SpringBootApplication
public class BourseServiceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BourseServiceApplication.class, args);
		SocieteRepository societeRepository=ctx.getBean(SocieteRepository.class);
		Stream.of("Axa credit", "Ciments du maroc", "Zellidja s.a", "Diac salaf", "Samir", "Bmci",
				"Wafa assurances", "Aluminium du maroc",
				"Agma lahlou-tazi", "Afriquia gaz", "Auto hall", "Maghreb oxygene",
				"Rebab company", "Auto nejma", "Managem", "Ib maroc.com", "Nexans maroc",
				"Maghrebail", "Dari couspate", "Lydec", "Med paper").forEachOrdered(s->societeRepository.save(new Societe(s)));
		societeRepository.findAll().forEach(s->System.out.println(s.getNomSociete()));
	}
}
// cette configuration nous permet de recuperer l’id de chaque societe
@Configuration
class MyConfig extends RepositoryRestConfigurerAdapter/*RepositoryRestMvcConfiguration*/{
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Societe.class);
	}
}