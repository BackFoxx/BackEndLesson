package com.example.springrealsecurity.security.configs;

import com.example.springrealsecurity.security.common.FormAuthenticationDetailsSource;
import com.example.springrealsecurity.security.filter.AjaxLoginProcessingFilter;
import com.example.springrealsecurity.security.handler.CustomAccessDeniedHandler;
import com.example.springrealsecurity.security.handler.CustomAuthenticationFailureHandler;
import com.example.springrealsecurity.security.handler.CustomAuthenticationSuccessHandler;
import com.example.springrealsecurity.security.provider.FormAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    AuthenticationConfiguration configuration;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web ->
                web.ignoring()
                        .requestMatchers(PathRequest.toStaticResources()
                                .atCommonLocations());
        /*
        * 인가 검증을 거치지 않는다.
        * .antMatchers.permitAll()과 달리 FilterSecurityInterceptor 자체를 거치지 않는다.
        * */
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new FormAuthenticationProvider();
    }

    @Bean
    public AuthenticationDetailsSource authenticationDetailsSource() {
        return new FormAuthenticationDetailsSource();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler("/denied");
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return this.configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/users", "/login*").permitAll()
                .antMatchers("/mypage").hasRole("USER")
                .antMatchers("/messages").hasRole("MANAGER")
                .antMatchers("/config").hasRole("ADMIN")
                .anyRequest().authenticated();
        http
                .authenticationProvider(this.authenticationProvider());
        http
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login_proc")
                .defaultSuccessUrl("/")
                .successHandler(this.authenticationSuccessHandler())
                .failureHandler(this.authenticationFailureHandler())
                /* defaultSuccessUrl 아래에 위치해야 작동한다. */
                .permitAll()
                .authenticationDetailsSource(this.authenticationDetailsSource());
        http
                .exceptionHandling()
                .accessDeniedHandler(this.accessDeniedHandler());
        http.csrf().disable();

        AjaxLoginProcessingFilter ajaxLoginProcessingFilter = new AjaxLoginProcessingFilter();
        ajaxLoginProcessingFilter.setAuthenticationManager(this.authenticationManager());

        http
                .addFilterBefore(ajaxLoginProcessingFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
