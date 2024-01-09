package cat.itacademy.barcelonactiva.lopez.pedro.s05.study.config;

import ch.qos.logback.classic.joran.action.ConfigurationAction;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

@Log4j2
@EnableConfigurationProperties(BootifulProperties.class)
@SpringBootApplication
public class SpringBootConfigurationTipsApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootConfigurationTipsApplication.class, args);
		new SpringApplicationBuilder()
				.sources(SpringBootConfigurationTipsApplication.class)
				//.initializers(applicationContext -> applicationContext.getEnvironment().getPropertySources().addLast(new BootifulPropertySource()))
				.run(args);
	}

	@Autowired
	void contributeToPropertySources(ConfigurableEnvironment environment) {
		environment.getPropertySources().addLast(new BootifulPropertySource());
	}

	@Bean
	ApplicationRunner applicationRunner (Environment environment,
										 @Value("${say-welcome:Default welcome!}") String defaultWelcome,
											@Value("${Home}") String userHome,
												@Value("${spring.datasource.url}") String springDataSourceURL,
										 			@Value("${bootiful-message}") String bootifulMessage,
										 			BootifulProperties bootifulProperties) {
		return args -> {
			log.info("A message from application properties: " +
					environment.getProperty("message"));
			log.info("Welcome message: " + defaultWelcome);
			log.info("User home: " + userHome);
			log.info("Data source URL: " + springDataSourceURL);
			log.info("Message from custom PropertySource: " + bootifulMessage);
			log.info("Message from @ConfigurationProperties: " + bootifulProperties.getMessage());
		};
	}


}
