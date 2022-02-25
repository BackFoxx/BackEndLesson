package guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"guestbook.dao", "guestbook.service"})
@Import(DBConfig.class)
public class ApplicationConfig {
}
