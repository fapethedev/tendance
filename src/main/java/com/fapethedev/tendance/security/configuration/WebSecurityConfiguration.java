package com.fapethedev.tendance.security.configuration;

import com.fapethedev.tendance.security.manager.UserLoginManager;
import com.fapethedev.tendance.users.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration
{
    private final UserLoginManager userLoginManager;

    @Autowired
    public WebSecurityConfiguration(UserLoginManager userLoginManager) {
        this.userLoginManager = userLoginManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.userDetailsService(userLoginManager)
                .authorizeHttpRequests(ressourceRequestMatcher())
                .authorizeHttpRequests(controllerRequestMatcher())
                .httpBasic(Customizer.withDefaults())
                .formLogin(formLogin())
                .rememberMe(rememberMe())
                .logout(logout())
                .sessionManagement(sessionManagement())
                .exceptionHandling(exceptionHandling());

        return http.build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    private Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> ressourceRequestMatcher()
    {
        return c -> c.requestMatchers("/assets/**")
                .permitAll()
                .requestMatchers("/dashboard/assets/**")
                .permitAll()
                .requestMatchers("/favicon/**")
                .permitAll()
                .requestMatchers("/site/assets/**")
                .permitAll();
    }

    private Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> controllerRequestMatcher()
    {
        return c -> c.requestMatchers("/**")
                .permitAll()
                .requestMatchers("/register/**")
                .permitAll()
                .requestMatchers("/dashboard/**")
                .hasAuthority(Role.Category.ROLE_STANDARD.name())
                .requestMatchers("/cart/**")
                .hasAuthority(Role.Category.ROLE_STANDARD.name());
    }

    private Customizer<FormLoginConfigurer<HttpSecurity>> formLogin()
    {
        return c -> c.loginPage("/login")
                .loginProcessingUrl("/authentication")
                .defaultSuccessUrl("/dashboard/", true)
                .passwordParameter("password")
                .usernameParameter("username")
                .permitAll();
    }

    private Customizer<RememberMeConfigurer<HttpSecurity>> rememberMe()
    {
        return c -> c.rememberMeCookieName("RMBCOOKIE")
                .rememberMeParameter("remember-me")
                .key("rememberMKey")
                .tokenValiditySeconds(3600 * 24 * 15)
                .useSecureCookie(true)
                .tokenRepository(new JdbcTokenRepositoryImpl());
    }

    private Customizer<LogoutConfigurer<HttpSecurity>> logout()
    {
        return c -> c.logoutUrl("/logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID" ,"RMBCOOKIE")
                .permitAll();
    }

    private Customizer<SessionManagementConfigurer<HttpSecurity>> sessionManagement()
    {
        return c -> c.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .sessionFixation()
                .changeSessionId()
                .maximumSessions(2)
                .maxSessionsPreventsLogin(true)
                .sessionRegistry(sessionRegistry())
                .expiredUrl("/login?expired");
    }

    private Customizer<ExceptionHandlingConfigurer<HttpSecurity>> exceptionHandling() {
        return c -> c.accessDeniedPage("/error");
    }
}
