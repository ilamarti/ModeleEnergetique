package ma.negpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"ma.negpm.dao"})
//@EntityScan(basePackages = {"ma.negpm.domain"})
public class ModeleEnergetiqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModeleEnergetiqueApplication.class, args);
	}

}
