package cat.itacademy.barcelonactiva.lopez.pedro.s05.study.config;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@Log4j2
@SpringBootApplication
public class SpringBootConfigurationTipsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigurationTipsApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner (Environment environment,
										 @Value("${say-welcome:Default welcome!}") String defaultWelcome) {
		return args -> {
			log.info("A message from application properties: " +
					environment.getProperty("message"));
			log.info("Welcome message: " + defaultWelcome);
		};
	}
}
