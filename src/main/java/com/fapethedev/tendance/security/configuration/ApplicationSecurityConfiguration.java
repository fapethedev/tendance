package com.fapethedev.tendance.security.configuration;

import com.fapethedev.tendance.security.handler.OAuth2AuthenticationFailureHandler;
import com.fapethedev.tendance.security.handler.OAuth2AuthenticationSuccessHandler;
import com.fapethedev.tendance.security.manager.OAuth2UserService;
import com.fapethedev.tendance.security.manager.UserLoginManager;
import com.fapethedev.tendance.users.entities.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;

/**
 * <p>Security configuration class.All the configurations and beans required for
 * security are inside this class.</p>
 * <p>Configuration like login with form, oauth2login or remember me and more (future features)
 * are implements here</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ApplicationSecurityConfiguration
{
    private static final String key = "rmb-app-key";

    private final UserLoginManager userLoginManager;

    private final OAuth2UserService oAuth2UserService;

    private final OAuth2AuthenticationFailureHandler failureHandler;

    private final OAuth2AuthenticationSuccessHandler successHandler;

    /**
     * <p>Initialize security on the application.</p>
     *
     * @param http the security
     * @return security filter chain for http request
     * @throws Exception if something goes wrong
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.userDetailsService(userLoginManager)
                .authorizeHttpRequests(ressourceRequestMatcher())
                .authorizeHttpRequests(controllerRequestMatcher())
                .httpBasic(Customizer.withDefaults())
                .formLogin(formLogin())
                .oauth2Login(oauth2Login())
                .rememberMe(rememberMe())
                .logout(logout())
                .sessionManagement(sessionManagement())
                .exceptionHandling(exceptionHandling());

        return http.build();
    }

    /**
     * <p>Creates a bean of password encoder.</p>
     *
     * @return a password encoder with BCrypt as default algorithm
     */
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * <p>Creates a service for enable the remember me login functionality.
     * The remember service will be create use the key, the userDetailsService and optionally a token repository
     * for persist token or a token base algorithm for hashing the token.
     * </p>
     *
     * @return a remember me service bean
     */
    @Bean
    PersistentTokenBasedRememberMeServices rememberMeServices()
    {
        var tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setCreateTableOnStartup(true);

        return new PersistentTokenBasedRememberMeServices(key, userLoginManager, tokenRepository);
    }

    /**
     * <p>Creates a bean of {@code AuthenticationProvider}
     * with our remember me key.</p>
     *
     * @return a RememberMeAuthenticationProvider with remember me key
     */
    @Bean
    RememberMeAuthenticationProvider rememberMeAuthenticationProvider()
    {
        return new RememberMeAuthenticationProvider(key);
    }


    /**
     * <p>Creates an remember me authentication filter.</p>
     *
     * @param services the remember me services
     * @param provider the authentication provider
     *
     * @return the remember me authentication filter
     */
    @Bean
    RememberMeAuthenticationFilter rememberMeFilter(PersistentTokenBasedRememberMeServices services, RememberMeAuthenticationProvider provider) {
        return new RememberMeAuthenticationFilter(new ProviderManager(provider), services);
    }

    /**
     * <p>Creates a publisher for http session event.</p>
     *
     * @return http session publisher
     */
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    /**
     * <p>Creates a session registry for storing users session after they login.
     * </p>
     *
     * @return the session registry
     */
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    /**
     * <p>Custom request matchers for authorize application web resources.</p>
     *
     * @return the resources request matcher configurer
     */
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

    /**
     * <p>Customize request matchers for web application pages url.</p>
     *
     * @return the application pages request matcher configurer
     */
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

    /**
     * <p>Return the configuration for login with login page.</p>
     *
     * @return login form configurer with http security
     */
    private Customizer<FormLoginConfigurer<HttpSecurity>> formLogin()
    {
        return c -> c.loginPage("/login")
                .loginProcessingUrl("/authentication")
                .defaultSuccessUrl("/dashboard/", true)
                .passwordParameter("password")
                .usernameParameter("username")
                .permitAll();
    }

    /**
     * <p>Returns the configuration for oauth2 login.</p>
     *
     * @return oauth2 login configurer with http security
     */
    private Customizer<OAuth2LoginConfigurer<HttpSecurity>> oauth2Login()
    {
        return  o -> o.loginPage("/login")
                .defaultSuccessUrl("/dashboard/", true)
                .userInfoEndpoint(i -> i.userService(oAuth2UserService))
                .successHandler(successHandler)
                .failureHandler(failureHandler);
    }

    /**
     * <p>Configure the remember login after login with form.</p>
     *
     * @return a customizer of remember me
     */
    private Customizer<RememberMeConfigurer<HttpSecurity>> rememberMe()
    {
        return c -> c.rememberMeCookieName("RMBCOOKIE")
                .rememberMeParameter("remember-me")
                .useSecureCookie(true)
                .tokenValiditySeconds(3600 * 24 * 24)
                .rememberMeServices(rememberMeServices());
    }

    /**
     * <p>Configure the logout of an authenticated user.</p>
     *
     *@return a customizer of logout configurer with http security
     */
    private Customizer<LogoutConfigurer<HttpSecurity>> logout()
    {
        return c -> c.logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID" ,"RMBCOOKIE")
                .permitAll();
    }


    /**
     * <p>Configure the session management.</p>
     *
     * @return a customizer for configured session management
     */
    private Customizer<SessionManagementConfigurer<HttpSecurity>> sessionManagement()
    {
        return c -> c.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .sessionFixation()
                .changeSessionId()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true)
                .sessionRegistry(sessionRegistry())
                .expiredUrl("/login?expired");
    }

    /**
     * <p>Configure the security exception handling like authentication failure
     * or unauthorized access.</p>
     *
     * @return a customizer for handling exceptions
     */
    private Customizer<ExceptionHandlingConfigurer<HttpSecurity>> exceptionHandling() {
        return c -> c.accessDeniedPage("/error");
    }
}
