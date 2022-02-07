package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"repository", "service", "controller"})
@Import(DataSourceConfig.class)
public class ApplicationConfig {
}
