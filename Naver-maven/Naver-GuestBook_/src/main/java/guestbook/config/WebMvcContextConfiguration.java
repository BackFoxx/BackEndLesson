package guestbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "guestbook.controller")
public class WebMvcContextConfiguration implements WebMvcConfigurer {
    public static final int CACHE_PERIOD = 31556926;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(CACHE_PERIOD);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(CACHE_PERIOD);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(CACHE_PERIOD);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        System.out.println("addViewControllers가 호출됩니다. ");
        registry.addViewController("/").setViewName("index");
    }
    //컨트롤러를 통하지 않고 view로 직행

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
