package din.norms.dinspringbootprojectworkspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"din.norms.dinspringbootprojectworkspace.repository"})
@EntityScan(basePackages = {"din.norms.dinspringbootprojectworkspace.model"})
public class DinNormsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DinNormsApplication.class, args);
    }

}
