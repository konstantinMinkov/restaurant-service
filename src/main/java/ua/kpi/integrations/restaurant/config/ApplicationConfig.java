package ua.kpi.integrations.restaurant.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(RepositoriesConfig.class)
@ComponentScan(basePackages = {"ua.kpi.integrations.restaurant.domain",
        "ua.kpi.integrations.restaurant.services"})
public class ApplicationConfig {
}
