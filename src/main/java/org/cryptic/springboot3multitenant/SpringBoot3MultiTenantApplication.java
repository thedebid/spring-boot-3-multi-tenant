package org.cryptic.springboot3multitenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("org.cryptic.springboot3multitenant.*")
@EnableJpaRepositories(basePackages = "org.cryptic.springboot3multitenant.repository")
@EntityScan(basePackages = "org.cryptic.springboot3multitenant.entity")
public class SpringBoot3MultiTenantApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3MultiTenantApplication.class, args);
    }

}
