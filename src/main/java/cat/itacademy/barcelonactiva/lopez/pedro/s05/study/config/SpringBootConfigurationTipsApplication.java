package cat.itacademy.barcelonactiva.lopez.pedro.s05.study.config;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@Log4j2
@SpringBootApplication
public class SpringBootConfigurationTipsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigurationTipsApplication.class, args);
	}

	ApplicationRunner applicationRunner (Environment environment) {
		return args -> {
			log.info("A message from application properties: " +
					environment.getProperty("message"));
		};
	}
}
