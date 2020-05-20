package employee.springrest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository repository) {
    return args -> {
        repository.save(new Employee("Igor Aparecido da silva", "Developer"));
        repository.save(new Employee("Vinicius Aparecido da Silva", "Gamer"));
    };
  }
}