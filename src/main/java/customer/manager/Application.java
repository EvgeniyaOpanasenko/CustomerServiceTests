package customer.manager;

import customer.manager.model.Customer;
import customer.manager.model.User;
import customer.manager.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner setup(UserRepository repository) {
        return (args) -> {
            repository.save(new User("Ivan"));
            repository.save(new User("Eva"));
            repository.save(new User("Kolya"));

            logger.info("The sample data has been generated");
        };
    }
}
