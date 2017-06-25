package pl.edu.wat;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;

@SpringBootApplication(exclude = {LiquibaseAutoConfiguration.class})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JokeboxApplication {

/*	@Autowired
	Crawler crawler;

	@PostConstruct
	public void initializeDatabase(){
		crawler.init();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(JokeboxApplication.class, args);
	}

}
