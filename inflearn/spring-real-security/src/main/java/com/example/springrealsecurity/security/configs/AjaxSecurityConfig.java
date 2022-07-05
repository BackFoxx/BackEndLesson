package com.example.springrealsecurity.security.configs;

import com.example.springrealsecurity.security.common.AjaxLoginAuthenticationEntryPoint;
import com.example.springrealsecurity.security.filter.AjaxLoginProcessingFilter;
import com.example.springrealsecurity.security.handler.AjaxAccessDeniedHandler;
import com.example.springrealsecurity.security.handler.AjaxAuthenticationFailureHandler;
import com.example.springrealsecurity.security.handler.AjaxAuthenticationSuccessHandler;
import com.example.springrealsecurity.security.provider.AjaxAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Order(1)
public class AjaxSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationConfiguration configuration;

    @Autowired
    AjaxAuthenticationProvider ajaxAuthenticationProvider;

    @Autowired
    AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;

    @Autowired
    AjaxAuthenticationFailureHandler ajaxAuthenticationFailureHandler;

    @Autowired
    AjaxLoginAuthenticationEntryPoint ajaxLoginAuthenticationEntryPoint;

    @Autowired
    AjaxAccessDeniedHandler ajaxAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .antMatcher("/api/**")
                .authorizeRequests()
                .antMatchers("/api/messages").hasRole("MANAGER")
                .anyRequest().authenticated();
        http
                .exceptionHandling()
                .authenticationEntryPoint(this.ajaxLoginAuthenticationEntryPoint)
                .accessDeniedHandler(this.ajaxAccessDeniedHandler);

        this.customConfigureAjax(http);
    }

    private void customConfigureAjax(HttpSecurity http) throws Exception {
        http
                .apply(new AjaxLoginConfigurer<>())
                .successHandlerAjax(this.ajaxAuthenticationSuccessHandler)
                .failureHandlerAjax(this.ajaxAuthenticationFailureHandler)
                .setAuthenticationManager(this.authenticationManagerBean())
                .loginProcessingUrl("/api/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(this.ajaxAuthenticationProvider);
    }
}
