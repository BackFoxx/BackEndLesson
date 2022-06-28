package io.security.basicsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .anyRequest().authenticated();
        http
                .formLogin();

        http
                .sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false);

//        http
//                .authorizeRequests()
//                .anyRequest().authenticated();
//        http
//                .formLogin()
//                //.loginPage("/loginPage") // 로그인 페이지
//                .defaultSuccessUrl("/") // 로그인 성공시 이동할 페이지.
//                .failureUrl("/login") // 로그인 실패시 이동할 페이지
//
//                .usernameParameter("userId") // 로그인 username 폼의 이름
//                .passwordParameter("passwd") // 로그인 password 폼의 이름
//                .loginProcessingUrl("/login_proc") // 로그인 로직을 수행할 uri
//
//                .successHandler((request, response, authentication) -> {
//                    System.out.println("authentication = " + authentication.getName());
//                    response.sendRedirect("/");
//                }) // 인증 성공시 실행할 메서드. 인증에 성공했을 때 인증 결과를 담은 Authentication 객체를 넘겨줌.
//                .failureHandler((request, response, exception) -> {
//                    System.out.println("exception : " + exception.getMessage());
//                    response.sendRedirect("/loginPage");
//                }) // 인증 실패시 실행할 메서드. 인증 실패시 던지는 AuthenticationException을 넘겨줌.
//                .permitAll(); // 로그인 페이지는 인증받지 않아도 사용이 가능해야 하므로 permitAll()을 설정해준다.
//
//        http
//                .logout()
//                .logoutUrl("/logout") // 로그아웃을 실행할 uri, 기본 http 메서드는 POST
//                .logoutSuccessUrl("/login") // 로그아웃 성공시 이동할 uri
//                .addLogoutHandler(new LogoutHandler() {
//                    @Override
//                    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
//                        System.out.println("로그아웃 중!");
//                    }
//                })
//                .logoutSuccessHandler((request, response, authentication) -> response.sendRedirect("/login")) // 로그아웃 성공시 실행할 핸들러
//                .deleteCookies("remember-me"); // 로그아웃시 삭제할 쿠키
//
//        http
//                .rememberMe()
//                .rememberMeParameter("remember") // remember-me 파라미터명
//                .tokenValiditySeconds(3600) // remember-me 만료시간
//                .userDetailsService(userDetailsService); // remember-me 처리시 유저 정보를 조회하는 클래스

        return http.build();
    }

}
